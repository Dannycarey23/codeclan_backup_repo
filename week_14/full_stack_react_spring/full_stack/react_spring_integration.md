# Integrating a React front-end with a Spring Boot back-end

## Objectives
- You will work with an existing React front-end application and learn how to connect it to a Spring Boot back-end API in order to retrieve, save and delete data. 
- You will learn how to add Spring controllers for deleting and updating existing Pirate data.
- You will learn how to work around CORS issues between a locally running React application and API during development.

## Preparing for the lesson
- Open the Pirates React start point in VS Code and install dependencies using `npm install`.
- Open the Pirates Spring start point in IntelliJ.
- Make sure you have a pirates database by running terminal command `createdb pirates`. If this already exists you may wish to start afresh by firstly dropping the database using terminal command `dropdb pirates` and then recreating it using `createdb pirates`.
- Ensure the database username and password are correct in the Spring project's application.properties file (for most students this should be `postgres` and `postgres` respectively).

## Review the start code
Let's take a few moments to review the start code. 

You should recognise the Spring application as the one we've been working on for the past few days. There are controllers for handling getting all, getting one and creating Pirate, Raid and Ship.

The React project you may remember from the React lessons. It uses React Router to organise pirate related routes under the PirateContainer component. There are existing routes to display all pirates, display a single pirate by its ID and a route to display the new pirate form.

The corresponding components - PirateList, PirateDetail and PirateForm have all been completed but rely on incomplete functionality/data in the PirateContainer component which is passed down to these components via props.

- PirateList relies on a `pirates` prop - intended to be an array of pirate objects. At the moment the PirateContainer useEffect call sets this to just an empty array `[]` but we will want to switch it out for data retrieved over an API call.
- PirateDetail also relies on this pirate data in order to locate the pirate by its ID but in addition a `handleDelete` function defined in PirateContainer which at the moment just redirects the user to the `/pirates` route. We'll want to update `handleDelete` to use our API.
- PirateForm relies on a `ships` prop - intended to be an array of ship objects which can be associated with a new pirate. At the moment the PirateContainer useEffect call sets this to just an empty array `[]` but we will want to switch it out for data retrieved over an API call. The `onCreate` prop also relies on a function `handlePost` defined in PirateContainer which currently doesn't make use of our API.
- The `helpers/request.js` file is intended to house our API fetch functionality but hasn't yet been implemented. 

## Step 1 - Retrieving all Pirates over the API
Let's start by implementing a function in the React project's `helpers/request.js` file to facilitate making a GET request to a given URL and processing the response as JSON data.

```js
// helpers/request.js

class Request {
    async get (url) {                       // ADDED
        const result = await fetch(url);
        return result.json();
    }
}

export default Request;
```

Here we've marked the `get` function as being `async` which simply means that JavaScript will permit us to use the `await` keyword inside of the function. The `await` keyword tells JavaScript to wait for a Promise to resolve (in this case the Promise returned by calling `fetch`) before continuing execution of the next line of code, thereby allowing synchronous execution and also allowing us to assign the result of the fetch request (instead of the Promise object) to a variable `result`.

Now that we have a function allowing us to make a GET request to a given URL, let's update the PirateContainer component to use it to fetch data from our Spring Boot API running on port 8080:

```js
// containers/PirateContainer.js

import Request from '../helpers/request';               // ADDED

...

useEffect(() => {
    const request = new Request();                      // ADDED

    const piratePromise = request.get('http://localhost:8080/api/pirates');  // UPDATED
    
    ...
}
```

If we now access the Pirates page with our React and Spring applications running, we'll see an error message about an Unhandled Rejection and if we further inspect the browser developer tools, see an error:

```
Access to fetch at 'http://localhost:8080/api/pirates' from origin 'http://localhost:3000' has been blocked by CORS policy: No 'Access-Control-Allow-Origin' header is present on the requested resource. If an opaque response serves your needs, set the request's mode to 'no-cors' to fetch the resource with CORS disabled.
```

What's this all about? Well our Spring Boot API is by default blocking any cross-origin requests made by the React app's client side code. We could configure our API to allow requests but this configuration is somewhat more complex. Instead, we could send our API requests through to the development server serving up our React app and ask it to proxy (send on the browser's behalf) the requests to the API.

To do this, we'll udpate the `package.json` file in the React project to include a proxy configuration:

```json
{
  "name": "pirate_refactor",
  "version": "0.1.0",
  "proxy": "http://localhost:8080/",

  ...

}
```

Now, any request sent from our client-side React app to the development server which isn't just to request a web page will be forwarded on to the Spring Boot API at `http://localhost:8080`. Now that we've done this we'll need to update the PirateContainer to navigate to a URL relative to this proxy address:

```js
// containers/PirateContainer.js

useEffect(() => {
    
    ...

    const piratePromise = request.get('/api/pirates');  // UPDATED
    
    ...
}
```

But hang on! Having changed this, we're now getting a pirates.map is not a function error! You may have wondered where the `/api` prefix in the URL came from - our Spring Boot controller is just `/pirates` so how is Spring going to recognise a request to `/api/pirates`? Well we could just remove the `/api` part of the URL but it's common practice to have this prefix in an API route. We could update our controller to use a value of `/api/pirates` but then every time we add a new controller we have to make sure we type `/api` before the URL value. There is another way! We can configure Spring to treat all requests relative to a root path. Let's update the Spring project's application.properties file:

```toml
# src/main/resources/application.properties

...

server.servlet.context-path=/api    # added
```

Now if we restart our Spring Boot API and retry the pirates page in our browser we should finally see pirate data.

## Step 2 - Saving a new pirate over the API
Let's look at the create pirate page. There seems to be an issue - we can't choose a ship as the ship dropdown is empty! The PirateContainer component currently sets the ships state - which is passed to the PirateForm component for its dropdown values - and this is still set to an empty array `[]`.

Now that we have a working `get` method in the Request class, we can replace the empty array assigned in the useEffect call with an API call:

```js
// containers/PirateContainer.js

useEffect(() => {
    const request = new Request();                      // AS BEFORE

    const piratePromise = request.get('/api/pirates');  // AS BEFORE
    const shipPromise = request.get('/api/ships');      // UPDATED
    
    ...

  }, [])
...

```

Now we can choose a ship, however if we save a new pirate, we're just redirected to the list of pirates - the pirate details are not persisted. The PirateForm component's form onSubmit callback function currently calls an `onCreate` function passed as a prop by the PirateContainer component. The latter passes the `handlePost` function which at present just accepts a pirate object and performs the browser redirect.

Let's add a new post function in our `request.js` file which can send an HTTP POST request to our API:

```js
// helpers/request.js

class Request {
    ...

    post(url, payload) {                    // ADDED
        return fetch(url, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(payload)
        })
    }
}

export default Request;
```

Note that since the default HTTP method type used by the fetch functino is `GET`, we need to pass an options object as a second argument in order to tell it to use the HTTP `POST` method. In addition, we set the `Content-Type` header to instruct our API the type of data we're sending (JSON) and set the body to our pirate object, converted from a JavaScript object (JSON) to a JSON string using the `JSON.stringify()` function.

Now we can update the `handlePost` function in PirateContainer to send a POST request with the pirate object to our API:

```js
// containers/PirateContainer.js

const handlePost = (pirate) => {
    const request = new Request();

    request.post('/api/pirates', pirate).then(() => {
        window.location = '/pirates'
    })
};
```

Note that we needed to create an instance of the Request class in order to call the `post` method and in addition, since we need to wait for the Promise returned from the `post` method's fetch to resolve before redirecting to the list of pirates, otherwise the request may not have yet completed.

Now, if we try saving a new pirate we should be redirected to the list of pirates and see our new pirate at the bottom of the list.

## Step 3 - Deleting a pirate over the API
If we view the details of an individual pirate by clicking its name and then click the Delete button, you'll note that it doesn't actually delete anything yet. A look at the `handleDelete` function inside PirateContainer shows that at the moment it gets passed as a prop to the PirateDetail component, which calls it with the pirate's ID, but the function doesn't do anything except redirect us back to the pirates list.

Let's add a new `delete` method to the Request class so we can send an HTTP DELETE request to our API:

```js
// helpers/request.js

class Request {
    ...

    delete(url) {                       // ADDED
        return fetch(url, {
            method: "DELETE"
        })
    }
}

```

Again, note that we need to tell the fetch function to use the HTTP `DELETE` method.

With this in place, we can update the PirateContainer's handleDelete method to use the new request method:

```js
// containers/PirateContainer.js
const handleDelete = (id) => {
    const request = new Request();          // UPDATED
    const url = '/api/pirates/' + id;

    request.delete(url).then(() => {
      window.location = '/pirates';
    })
}
```

Again, we ensure the browser redirect only happens once the request has successfully completed. But if we try this, the pirate is still in the list of pirates and inspect of the browser developer tools shows a `DELETE http://localhost:3000/api/pirates/1 405 (Method Not Allowed)` error. We haven't yet added a controller endpoint to our Sprin Boot API to handle this. Our PirateController does have an endpoint mapped to the URL path `/pirates/{id}` however this is only going to accept an HTTP `GET` request, since it's annotated with `@GetMapping`.

Let's fix that by adding a new controller endpoint. We know that we're going to send the ID of the pirate to delete but what, if anything, do we want our controller endpoint to return in the response? We could just return a success status code, and that would be fine. 

If we did that, we could use our Spring repository's built in `deleteById()` method, passing the ID from the URL parameter.

However it's quite common that the caller of the API might need to do something with the deleted object like display something to a user or log something, so let's first find the pirate by its ID, delete it and then return a response with the deleted pirate in the body:

```java
// src/main/java/controllers/PirateController.java

public class PirateController {
    ...

    @DeleteMapping(value = "/pirates/{id}")                 // ADDED
    public ResponseEntity<Pirate> deletePirate(@PathVariable Long id) {
        Optional<Pirate> pirateToDelete = pirateRepository.findById(id);
        pirateRepository.delete(pirateToDelete.get());
        return new ResponseEntity<>(pirateToDelete.get(), HttpStatus.OK);
    }

...

}
```

Note the `findById()` method returns an `Optional<Pirate>` - `Optional` just being a wrapper class introduced in Java 8 to make working with potentially null objects simpler. Accordingly, we need to get the actual pirate object by calling `.get()` on the Optional object. We'll just assume here that we'll only be passing a valid ID and therefore there will be a found pirate, but in reality we'd want to make sure there was an actual pirate in the Optional object before trying to get it, or Java would throw an exception.

With this now in place, if we restart our Spring Boot application and try and delete a pirate in the front-end, we'll see the list of pirates no longer contains it.

## Step 4 - Updating an existing pirate over the API
So far using our pirate application we can create, delete and retrieve but we can't update an existing pirate. Let's add a new React component allowing us to edit an existing pirate - we'll give you the code to save some time, just add this to a new file under the components folder and call it `PirateFormEdit.js`:

```js
// components/pirates/PirateFormEdit.js - new file

import React, { useState } from 'react';

const PirateFormEdit = ({ pirate, ships, onEdit }) => {

    const [statePirate, setStatePirate] = useState(
        {
            id: pirate.id,
            firstName: pirate.firstName,
            lastName: pirate.lastName,
            age: pirate.age,
            ship: pirate.ship
        }
    )

    if (ships.length === 0 || !pirate) {
        return <p>Loading...</p>
    }

    const handleChange = function (event) {
        let propertyName = event.target.name;
        let copiedPirate = { ...statePirate }
        copiedPirate[propertyName] = event.target.value;
        setStatePirate(copiedPirate)
    }

    const handleShip = function (event) {
        const selectedShip = ships.find(ship => ship.id == event.target.value);
        let copiedPirate = { ...statePirate };
        copiedPirate['ship'] = selectedShip
        setStatePirate(copiedPirate)
    }

    const handleSubmit = function (event) {
        event.preventDefault();
        onEdit(statePirate);
    }

    const shipOptions = ships.map((ship, index) => {
        return <option key={index} value={ship.id}>{ship.name}</option>
    })

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <input type="text" placeholder="First Name" name="firstName" onChange={handleChange} value={statePirate.firstName} />
                <input type="text" placeholder="Last Name" name="lastName" onChange={handleChange} value={statePirate.lastName} />
                <input type="number" placeholder="Age" name="age" onChange={handleChange} value={statePirate.age} />
                <select name="ship" onChange={handleShip} defaultValue={pirate.ship.id}>
                    <option disabled value='select-ship'>Select a ship</option>
                    {shipOptions}
                </select>

                <button type="submit">Save</button>
            </form>
        </div>
    )

}

export default PirateFormEdit;
```

You'll probably note that this file is very similar to the existing `PirateForm.js` file but with a few differences:
- We pass a `pirate` prop to the component (so we know the existing pirate's data)
- Instead of passing an `onCreate` prop function, we pass an `onEdit`
- Instead of setting the initial pirate state to empty strings etc, we set it to be based on the pirate prop data
- Instead of handling change of the ship dropdown to be based on the ship's index in the array of ships, we use its ID

With that in place, we also need to add:
- A route to our PirateContainer component allowing us to view the edit form
- A button to our PirateDetail component which navigates to this route
- A new `put` funciton in our Request class allowing us to make an HTTP PUT request to the API
- A function in our PirateContainer to handle sending the PUT request, which we can pass as an `onEdit` prop to the PirateFormEdit component

Let's firstly add the `put` function:

```js
// helpers/request.js

class Request {
    ...

    put(url, payload) {                         // ADDED
        return fetch(url, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(payload)
        })
    }
}
```

Notice that we set the fetch method to `PUT` since we're updating an existing resource. Our function accepts a URL and a payload, similar to the `post` method, since we need to send the updated entity in the request body.

Now let's add a button to the PirateDetail component which will navigate to the editing route. We could simply use a normal browser redirect here, in which case we'd need to make an API request to get the pirate being edited by its ID (since a normal browser navigation causes loss of the React state) however we can keep things simple by using the React Router `useNavigate` hook to simulate navigation but without loss of state, allowing us to use the pirate data already in state:

```js
// components/PirateDetail.js

import React from 'react';
import Pirate from "./Pirate";

import { useNavigate } from 'react-router-dom';         // ADDED


const PirateDetail = ({ pirate, handleDelete }) => {
    const navigate = useNavigate();                     // ADDED

    ...

    const onEdit = () => {                              // ADDED
        navigate(`/pirates/${pirate.id}/edit`);
    }

    return (
        <div className="component">
            <Pirate pirate={pirate} />
            <p>Raids:</p>
            <ul>
                {piratesRaids}
            </ul>
            <p>Ship:</p>
            <p>{pirate.ship.name}</p>
            <button onClick={onDelete}>Delete {pirate.firstName}</button>
            <button onClick={onEdit}>Edit</button>          {/* ADDED */}
        </div>
    )
```

So we know that our new route will need to map a URL of `/pirates/:id/edit`. Let's make the final changes needed in our PirateFormEdit component:

```js
// containers/PirateFormEdit.js
...
import PirateFormEdit from '../components/pirates/PirateFormEdit';  // ADDED

const PirateContainer = () => {
    ...

    const PirateFormEditWrapper = () => {           // ADDED
        const { id } = useParams();
        let foundPirate = findPirateById(id);
    
        return <PirateFormEdit ships={ships} pirate={foundPirate} onEdit={handlePut} />;
    }

    const handlePut = (pirate) => {                 // ADDED
        const request = new Request();

        request.put(`/api/pirates/${pirate.id}`, pirate).then(() => {
            window.location = '/pirates'
        })
    }

    return (
        <Routes>
        <Route path="/new" element={
            <PirateForm ships={ships} onCreate={handlePost} />
        } />

        {/* ADDED */}
        <Route path="/:id/edit" element={ <PirateFormEditWrapper /> } />

        <Route path="/:id" element={
            <PirateDetailWrapper />
        } />

        <Route path="/" element={<PirateList pirates={pirates} />} />
        </Routes>
    )
}

```

Notice that similar to the PirateDetail component, we used a wrapper function `PirateFormEditWrapper` to make it easier to determine and pass the correct props to the PirateFormEdit component. We used the `useParams` React Router hook to be able to access the ID `/:id/` from the URL.

If we test this out, we'll realise we haven't quite gotten everything in place - we still need to implement the Spring controller in the `PirateController.java` file. Let's implement that now:

```java
// src/main/java/controllers/PirateController.java

public class PirateController {
    ...

    @PutMapping(value = "/pirates/{id}")                // ADDED
    public ResponseEntity<Pirate> updatePirate(@RequestBody Pirate updatedPirate, @PathVariable Long id) {
        Pirate existingPirate = pirateRepository.findById(id).get();

        existingPirate.setAge(updatedPirate.getAge());
        existingPirate.setFirstName(updatedPirate.getFirstName());
        existingPirate.setLastName(updatedPirate.getLastName());
        existingPirate.setShip(updatedPirate.getShip());

        pirateRepository.save(existingPirate);

        return new ResponseEntity<>(existingPirate, HttpStatus.OK);
    }
}
```

Because we're specifying a mapping for `PUT` requests, we can use the same URL mapping `/pirates/{id}` as is already used by the delete and get endpoints. In order that we can more safely guarantee that we're updating the correct resource, and to follow RESTful conventions, our endpoint expects the ID to be specified in the URL (we could technically just retrieve this from the pirate object in the body but we want to be explicit in which entity we should be updating).

Since we want to update the entity managed by Spring JPA, we first retrieve the existing entity using the repository's `findById` method and then set the properties on this entity to match those in the request body pirate containing the details as entered in the front-end, before then saving the existing pirate entity. We could also use Spring's `copyProperties` method in the `org.springframework.beans.BeanUtils` package which saves us having to manually type multiple get and set method calls as well as specifying any property to be excluded from copying.

Finally, similar to the delete endpoint, we return the updated existing pirate in the response body, in case the API caller requires it.

And that's it, we can now restart our Spring application and test that the pirate can be edited and saved through the web application.
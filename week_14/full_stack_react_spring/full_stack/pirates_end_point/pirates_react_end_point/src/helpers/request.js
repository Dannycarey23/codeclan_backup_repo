/**
 * Create an instance of this class e.g. `const request = new Request()`
 * and call methods on it, e.g. `request.get('myurl.com')`.
 */
class Request {
    // The use of async and await allow us to treat an asynchronous function like
    // fetch as though it were synchronous, e.g. wait for the fetch promise to resolve
    // and then assign the value of the promise to the result variable. If we want to handle
    // errors like we would have done using somePromise.then(...).catch(<some error handling>)
    // we can wrap the await function call in a try...catch block
    async get (url) {
        const result = await fetch(url);
        return result.json();
    }

    // the above could have been written as the below, following the pattern of the delete, post and put
    // methods:
    //
    // get(url) {
    //     return fetch(url).then(result => result.json());
    // }

    delete(url) {
        return fetch(url, {
            method: "DELETE",
            headers: { "Content-Type": "application/json" }
        })
    }

    post(url, payload) {
        return fetch(url, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(payload)
        })
    }

    put(url, payload) {
        return fetch(url, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(payload)
        })
    }
}

export default Request;

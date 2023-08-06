# Lab: DevOps - Cloud & CI/CD

## Introduction

In this lab we will take a React app, much like one you might have written before, and deploy it to an AWS S3 Bucket. Once it's live, we'll configure a continuous integration pipeline to run a test suite every time code is pushed to the `develop` or `main` branches. If the pipeline fails, email notifcations can be sent out to team members, informing them that broken code has somehow ended up on an important branch.

Once our CI pipeline is working, we will automate deployment from the `main` branch. Every time code is merged to the `main` branch our CI pipeline will run and our code will be automatically deployed to our S3 bucket as long as the tests pass.

## The Stuff We Already Know How to Do

Let's start by taking a few minutes to familiarise ourselves with the project that we will be using for this lab. Open up a Terminal window and navigate to the project directory.

```sh
cd start_code
```

This is a React app, so we need to run a few commands in order to get the project up and running in our dev environment (the computer that we want to work on the project from). We need to install all of the dependencies of the project via NPM and we need to spin up a server so that we can see the project running in the browser.

```sh
npm install
npm start
```

You should now see the app running in a web browser.

We'll leave that server running for now, so open a new tab or window in Terminal and let's take a look at the tests that we will configure our continuous integration pipeline to run later on.

There isn't a great deal of logic in this app, so we just have one simple unit test which tests that the app loads without crashing.

```sh
npm test
```

We also have a couple of simple end to end tests.

```sh
npm run test:e2e
```

And we're using ESLint for static analysis to check that our code is formatted correctly.

```sh
npm run lint
```

> Note: If you don't see much output from this command, that's a good thing. ESLint becomes very vocal when it's unhappy.

Next, open the codebase up in your favourite text editor and spend a few minutes reading the containers and components.

```sh
code .
```

Now that we know what we're dealing with, let's get the project checked in to a version control system.

```sh
git init
git add --all
git commit -m 'Initial commit'
```

We'll need to have the code hosted in a remote repo, so sign into GitHub and create a new repository called "hit-parade". Then we'll link the remote GitHub repository to our local git repository and push the code to the `main` branch.

```sh
git remote add origin [GitHub SSH here]
git push -u origin main
```

Now that our dev environment is set up and the project is checked in to version control, we're ready to step out of our comfort zone and get the app deployed in a live environment.

## Deploying the App to AWS S3

The first thing that we will do is deploy our app to the cloud. To do this, we will need to [sign up for an AWS account](https://portal.aws.amazon.com/gp/aws/developer/registration/index.html?nc2=h_ct&src=header_signup). You will be required to enter payment details as part of the registration process but we will only be using free features, so you won't need to pay for anything.

Once the registration process has been completed, it can take a few minutes for your account to activate. You may wish to grab a cup of tea or coffee before we continue. Once your account is activated, you should be asked whether you would like to sign in as "root user" or "IAM user". The root user is like a superadmin with completely unrestricted permissions. IAM allows us to create additional users with specific permissions for specific tasks. We'll just use root for now.

Clicking the "Services" button in the top-left of the page will allow us to see all of the different services that AWS offer. Spoiler, there are A LOT! Fortunately, we can safely ignore the vast majority for now. We'll just be using an S3 bucket which you can find under "Storage". Go ahead and click on "S3".

An S3 bucket is just a little container that we can use to store files in the cloud. We can pop our React app in an S3 bucket and tell AWS to serve the index.html whenever someone tries to access the bucket. Just like that, our little React app will be live and publically accessible to anyone with the link.

There should be an orange button that says "Create bucket" on the right side of your screen. Click on it and let's get our new bucket set up.

The name of our bucket must be unique, so name your bucket `hit-parade-unique` replacing "unique" with something like your cohort number and name or initials to create a unique name for your bucket, for example `hit-parade-g42-lisa-simpson`. It doesn't matter what you name the bucket, as long as you remember it for later and it's relatively easy to type and check for correctness.

Under AWS Region, select "EU (London) eu-west-2".

Amazon S3 buckets can be used for many different things. You can simply use them to store files, in which case you may want those files to be private, or you can use them to make files publically accessible like a web server might. Uncheck "block all public access". We need our files to be publically accessible so that our little React app is publically available.

Check "I acknowledge that the current settings might result in this bucket and the objects within becoming public". We definitely need the files in our bucket to be public.

Once the bucket has been created, you should see it listed. Click on the name of your bucket to open it, so that we can configure it to host our app.

Click on properties, look for "Static website hosting" and be sure to enable it. This will allow us to tell AWS S3 to send the index.html when someone tries to access our bucket, just like a server would. To do that, set the index document to index.html.

When you've done that, click on "Save changes".

One last little bit of configuration and then we're ready to deploy our little app. Click on "Permissions" and then "Bucket policy". We need to add a small JSON snippet here to allow read access to our bucket.

```json
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "PublicReadGetObject",
            "Effect": "Allow",
            "Principal": "*",
            "Action": "s3:GetObject",
            "Resource": [
              "arn:aws:s3:::NAME-OF-YOUR-S3-BUCKET-HERE",
              "arn:aws:s3:::NAME-OF-YOUR-S3-BUCKET-HERE/*"
            ]
        }
    ]
}
```

> Note: Be sure to change `NAME-OF-YOUR-S3-BUCKET-HERE` to the actual name of your S3 bucket.

Okay, we're finally ready to take our little React app and host it in our bucket.

Click on "Objects" and then "upload". But what do we want to upload to the bucket? Web browsers don't understand React or JSX syntax by default, so we'll need to have React build a production version of our app that browsers understand how to run.

Make sure Object Ownership is set to "Bucket owner preferred" and ACLs enabled is checked.

With our project open in Terminal, run the following command:

```sh
npm run build
```

The `build` script will create a directory called "build" and dump all of our production ready files into it. Those are the files that we want to upload to our bucket. The build folder is in the .gitignore by default for React projects, so we don't need to worry about accidentally uploading these files which aren't necessary for development to GitHub. Very convenient!

```sh
ls

# We should see that React has created a build directory
```

```sh
ls build

# We should see our index.html and other files in this directory
```

Okay, back to AWS... We have the files that we want to upload, now we just need to upload them.

Click on "Add files" and select all of the files in the build directory of our React project.

Next, click on "Add folder" and select the "static" directory within the build directory of our React project.

Finally, click "upload" and we should be done!

Once the upload has completed, select "Properties" and scroll down to "static website hosting". You should see a URL here that can be used to access our app. We could buy a domain like hitparade.com and point that to our S3 bucket, but that would cost money and might be a bit much for this lab. If you click on the URL, you should see our little React app live on the internet and accessible from any device with an internet connection. Woo!

## Integrating CircleCI...

Let's take a moment to reflect on what we've done and where we are with the project.

We have a React app and the source code is being managed by GitHub. We have built a production version of our React website and manually deployed it to AWS S3. This version is now live and publically accessible on the internet.

The next step is to configure a pipeline using CircleCI, so that we can automate the running of our tests every time changes are pushed to important branches like `main` or `develop`. This process of defining a pipeline that runs every time new code is integrated into our existing source code is called continuous integration.  

### Continuous Integration

We use CircleCI by adding a configuration file to our project, which CircleCI will read and use to decide what to do when we push changes to GitHub. That configuration file must live in a hidden directory called `.circleci`, so let's go ahead and create that directory.

```sh
mkdir .circleci
```

Inside of that directory, we must create a file called `config.yml` which will contain all of our configuration details. .yml is the file extension used for YAML files. YAML is a data-serialization language (like JSON) that is often used for configuration files. It's very similar to JSON, the major difference being that, like Python, its syntax is based on whitespace (linebreaks and indentation) instead of brackets. This makes YAML very readable, perfect for configuration files that exist only to state information.

Let's create the config file that we'll use to store our configuration.

```sh
touch .circleci/config.yml
```

Now that we have a .yml file, we'll need some YAML to put in it. We'll give you the configuration and then break it down so that we understand what it does.

```yml
# .circleci/config.yml

version: 2.1
jobs:
  test:
    docker:
      - image: cimg/node:16.15.0
    steps:
      - checkout
      - run: npm install
      - run: npm test
      - run: npm run lint
workflows:
  version: 2.1
  build:
    jobs:
      - test:
          filters:
            branches:
              only:
                - main
                - develop
```

`version: 2.1` states that we are using version 2.1 of CircleCi.

`jobs` allows us to define a series of different tasks to run as part of our pipelines. In a real-world app, we might have many different types of tests and running them all might take a long time. We might want to only run some of them when we push to certain branches, but all of them when we push to very important branches like `main` and `develop`. For the sake of simplicity, we will bundle all of our tests into a single job called "test".

Within the test job, we define a series of steps that should run without error in order for our pipeline to complete successfully. Before we can do that, we need to determine what kind of environment our pipeline needs to run in. We will need the `circleci/node` configuration so that Node.js is installed in our environment, which will allow us to use commands like `npm` as part of our pipeline.

Once that's all taken care of, we can dictate the steps that our pipeline should go through as part of this job. The first step is `checkout`, which takes the current state of our source code from GitHub. Then we will need to use `npm install` to make sure that things like the React testing library and eslint, which we need to run our tests, are installed in the environment. Once that's done, we can finally run our tests and make sure that they all pass.

Once our jobs are defined, we need to tell CircleCI which jobs we want to run and when. We do this by defining `workflows`. Workflows are like batches of jobs. We want to run our test job only when commits are pushed to `main` or `develop`. We don't want everyone to receive email notifications if something breaks while someone's working safely on a feature branch, but we definitely want to know if broken code makes it to `develop` or `main`.

Now that we know vaguely what our configuration file is doing, let's commit and push it up to GitHub, then we can actually start using CircleCI.

```sh
git add --all
git commit -m 'Add CircleCI configuration'
git push origin main
```

First, [navigate to CircleCI](http://app.circleci.com) and sign in with GitHub. Once you've signed in select "Projects" and you should see all of your GitHub repositories. Select "hit-parade". CircleCI should detect our config file and allow us to select "start building". You may have to tell it which branch to look for the config in.

CircleCI should now run our pipeline to ensure that it works. It will take a few minutes to run and then should complete successfully.

Let's make a change to our code and push the change to check that our pipeline works as we expect it to. Open TitleBar.js and change the title to `<h1>CodeClan Hit Parade</h1>`. Now we'll add, commit and push this change and hopefully our pipeline will run again automatically.

```sh
git add --all
git commit -m 'Update title'
git push -u origin main
```

On CircleCI, select "Projects" and then "hit-parade" and you should see our pipeline running again. Again, it should take a few minutes to run and then complete successfully.

Congratulations! We now have continuous integration configured for our project and we should receive email confirmation if broken code ends up on the `main` or `develop` branches.

### Continuous Deployment

This is all very fancy but we can take it a step further still. Wouldn't it be great if we could have CircleCI automatically deploy to our AWS S3 bucket every time changes are pushed to the main branch? The good news is that we can!

This will require two main tasks - firstly, we'll need to update our CircleCI pipeline to tell it to deploy to AWS S3 when changes are made to the main branch. Then we'll need to authenticate CircleCI with AWS, so that AWS knows that it's okay for CircleCI to push files to our S3 bucket.

First, let's look at our config. Then we can worry about configuration when that's done. Just like last time, we'll give you the YAML snippet and then talk through what the various parts do.

Replace your existing config with the following one.

```yml
# .circleci/config.yml

version: 2.1
orbs:
  aws-s3: circleci/aws-s3@3.0.0
jobs:
  test:
    docker:
      - image: cimg/node:16.15.0
    steps:
      - checkout
      - run: npm install
      - run: npm test
      - run: npm run lint
  deploy:
    docker:
      - image: cimg/node:16.15.0
    environment:
      AWS_REGION: eu-west-2
    steps:
      - checkout
      - run: npm install
      - run: npm run build
      - aws-s3/sync:
          from: build
          to: 's3://NAME-OF-YOUR-S3-BUCKET-HERE/'
          arguments: |
            --acl public-read \
            --cache-control "max-age=86400" \
workflows:
  version: 2.1
  build:
    jobs:
      - test:
        filters:
          branches:
            only:
              - main
              - develop
      - deploy:
          requires:
            - test
          filters:
            branches:
              only: main
```

> Note: Be sure to change `NAME-OF-YOUR-S3-BUCKET-HERE` to the actual name of your S3 bucket.

The first thing that you'll notice is that a new section called `orbs` has appeared. Orbs are essentially like CircleCI libraries or packages that we can use to provide additionally functionality. Homebrew has kegs. Ruby has gems. NPM has packages. CircleCI has orbs. We will need to use the `circleci/aws-s3` orb so that CircleCI knows how to deploy to AWS S3.

Next, you'll note that we have added another `job`. As well as the `test` job that we added earlier, we now have another job called `deploy`. The `deploy` job pulls the latest changes from GitHub, then installs all of the NPM packages that we need, then it runs `npm run build` to create a production version of our code that can be deployed to S3 (just like we did manually in Terminal earlier), and then finally it syncs the contents of the build directory that it has just created with the contents of our S3 bucket.

We have also added the `deploy` job to our workflow, stating that it should only run when code is pushed to the `main` branch and it should only run if the `test` job has already completed successfully. We wouldn't want to deploy broken code by mistake!

This is all good and well but it won't actually work until we tell AWS that it's okay for CircleCI to deploy to our bucket.

Head back to AWS and click on your username in the top-right of the screen, then select "My Security Credentials".

On the security credentials page, click "Access Keys" and then "Create New Access Key".

Click "Show Access Key" and leave this page open, we'll need to enter this information into CircleCI.

Now we'll head back to CircleCI and enter our access keys. Click on "Projects", then "hit-parade", then "Project Settings".

Within project settings, click on "Environment Variables" then "Add Environment Variable". We add our access keys here, rather than in the configuration file, because we don't want them to be uploaded to GitHub where they may be publicly viewable. We will need to add two environment variables - `AWS_ACCESS_KEY_ID` and `AWS_SECRET_ACCESS_KEY`.

```
Name: AWS_ACCESS_KEY_ID  
Value: [Access Key ID (from AWS)]

Name: AWS_SECRET_ACCESS_KEY  
Value: [Secret Access Key (from AWS)]
```

NOTE: You might also have to add NODE_OPTIONS variable if you find that the CircleCI build fails

```
Name: NODE_OPTIONS
Value: --openssl-legacy-provider
```

Next we will commit the changes to our CircleCI configuration and check that the pipeline works.

```sh
git add --all
git commit -m 'Add deploy job'
git push origin main
```

Head back to CircleCI and check that the pipeline completes. It should have two jobs now, `test` and `deploy`. The `test` job should run first then, assuming that it completes successfully, the `deploy` job should run afterwards. If the `deploy` job completes successfully, we should be able to load up the live version of the app and see the change that we made to the title of the app earlier. It should say "CodeClan Hit Parade".

Feel free to make another change to the app and test the pipeline out again.

## What Happens Next?

If you made it this far - congratulations! You have deployed a React app to the cloud and configured a CI/CD pipeline. That's quite a lot for one day, but let's briefly discuss what could happen next if we were to continue.

Currently we have configured two jobs, a testing job and a deployment job. The testing job runs whenever we push code to an important branch and the deployment job runs whenever we push changes to the main branch. This seems a little risky though. I'd like to be a little bit more certain that our code works before we go live. This is where environments come in.

### Environments

Our `main` branch reflects the current state of our production environment. This is the real app that our real users see and interact with. Wouldn't it be nice if we had a dummy branch that deployed to a dummy version of the website, so that we could test that everything works correctly before we merge to main? This is where the staging environment comes in.

We could set up another job that deploys to a staging environment when we push to a staging branch of our repo. This would mean more tooling and more configuration, so we won't do this today, but it's food for thought! If you wanted to look into how to do this using the technologies that we used today, you'd be looking at using AWS Elastic Beanstalk for environment management.

## Conclusion

DevOps and the cloud are very broad topics that can't be covered at a reasonable level of detail a day, but we've looked into some of the key concept surrounding deployment.

We deployed a React app to the cloud. We configured a continuous integration (CI) pipeline with CircleCI, to automatically run tests against our source code whenever changes are pushed to an important branch. And we configured our pipeline to include continuous deployment (CD), automatically deploying our app to the cloud whenever changes are pushed to the main branch of our repository.

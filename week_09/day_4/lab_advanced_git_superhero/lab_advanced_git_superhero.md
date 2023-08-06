# Advanced Git

## Learning Objectives

- Know Git naming conventions
- Be able to create and move between branches
- Understand the difference between implicit and explicit merges
- Be able to merge branches and resolve merge conflicts
- Be able to use pull requests to merge branches
- Be able to apply Git hygiene
- Be able to use Git as part of a team

## Introduction

We have been using GitHub as a versioning tool to enable us to go back to previous version of our code. Git has a feature called branching that allow us to create parallel versions of our projects, so as to ensure we always have a stable version readily available. GitHub also has a whole host of features that allows developers to collaborate on projects, working on the code simultaneously.

## Git's Main Branch

Until now we have been working on one branch, the 'main' branch. In a Git initialised directory, you will see the word 'main' after the directory name in the terminal. This is the default branch that is created when we create a Git repository. (whether local or remote)

Until now, every time you have been committing your changes, you have been committing to main. You have then been able to use git commands to go back to a previous version of your code. One problem with this process is that it can be difficult to find the commit relating to the version you want to go back to. Branches help with this problem.

## Git Branches

With branches, once we have a stable version of a program committed to git and we are about to add a new piece of functionality or refactor the code in some way, we can create a new branch. This creates a copy of the code. The new branch will be in the same state as the branch you branched off. Now you can work in the new branch, adding your new feature or refactoring, knowing that you have a stable version back on the original branch should you decide to abandon the feature or you decide the refactor wasn't an improvement.

### Typical Branch Naming Conventions and Use Cases

Permanent Branches:

- "main" is the name of the default branch. This should always contain stable working code. Merging code into the main might involve -
  - Before the merge: Creating a Pull Request to get others to review and approve the merge into main
  - After the merge: Triggering CI / CD steps such as -
    - running automated tests 
    - linting code for consistent formatting
    - detecting security vulnerabilities in packages (aka dependencies)
    - deploying the code to production if all our checks pass

Temporary Branches:

- Feature branches are used to develop new functionality. The naming convention is 'feature/name_of_feature'. These branches are deleted after the feature is integrated back into main.
- Fix branches are used to fix a bug. There are different conventions, but you can use a prefix to indicate its purpose like, 'fix/name_of_fix'. These branches are deleted after the fix is integrated back into main.

Pushing to temporary branches may also involve some of the checks above for main (excluding production deployment!). In addition there may be deployments to staging or test environments to support automated and manual testing.

## Git Merging and Conflicts

When we merge two branches together, we integrate the code from one into the other. For example, when we have completed the feature on the feature branch we want and integrate the code into the main branch. Sometimes Git can do the integration process automatically for us, but when there have been changes made on both branches, Git may not know which lines to keep and which to discard, and we have to do it manually. This is called a merge conflict. This is a common problem when working collaboratively, where different people are working on different branches simultaneously and learning how to handle them is an important part of learning how to use Git.

The principle of merging branches is to first merge the stable branch (e.g. main) into the potentially unstable branch (e.g. feature) so that any conflicts can be dealt with and fixes made there. Once you are sure your feature branch is stable, you then merge it into main. This ensures the stable branch remains stable.

> Using a simple project, demonstrate with another member of the instructor team how to create and merge a pull request. Remind students that although the steps in the following task appear long, much of the work in GitHub is intuitive and user-friendly.
> Alternatively, you may prefer to do the task below as a codealong with another instructor (this can work well in a virtual classroom).

## Task (50 mins) 

In pairs work through the following steps to create and merge branches and deal with any git merge conflicts. Work through the steps together, so you understand each part of the process.

You are going to start with the main branch. Then you are going to be making feature branches and merging them into main.

### Person One

Person One is going to start by creating the directory structure. We'll do this on `main` as we want to lay down some foundations. You may want to take a similar approach at the start of your project before you start working on features - lay down all the known project structure rather than each creating your own and tripping over each other. But this is typically the only time you'd work directly on `main`. 

### Main branch

1. Create a local directory called `git_lab` and initialise git inside it - `git init`
2. Create a file called greet.js inside the directory
3. Add and Commit your changes to git
4. Create a new repo called 'git_lab' on GitHub, add it as the remote of your local directory and push the changes.
5. Add the following to greet.js:
```js
const helloWorld = () => {
  return "Hello World!";
}
```
6. Add and commit your changes.
7. Push to main branch - `git push origin main`. We now know the local and remote main branches are the same. 
8. Add your partner as a collaborator to the repository on GitHub by going to the repository page. Click `settings` then `collaborators` and add a new collaborator. This will enable your partner to push and pull to the repository directly.

### Person Two

Person Two is going to work on a feature and merge it into main.

1. Accept the invitation (you will have been sent an email).
2. Clone the repo.
3. Create a new new feature branch - `git checkout -b feature/add_default_param` - notice we are branching off of the main branch, so our new branch will be the same as main.
5. Refactor the function to have a `name` parameter with a default value:
```js
const helloWorld = (name = "World") => {
  return `Hello ${name}!`;
}
```
6. Add and commit the changes
7. Push to the feature branch - `git push origin feature/add_default_param`.

We know that 'feature/add_default_param' local and remote branches are the same.

> When you move between branches, your editor will automatically update to display the state of the current branch. If you now checkout to main, those changes you have just made will not be displayed in the editor. Then when moving back to the feature branch, they will appear again.
> VS Code will indicate which branch you are on, on a tab at the bottom left of your window.

## Creating a pull request

Now that Person Two has made a change to the code, we should create a pull request (often called a 'PR') via our GitHub repository. Pull requests are a feature from GitHub, not Git.

We use pull requests when we are working collaboratively. The purpose of a pull request is to present our code to other members of the team for review before those changes are merged into our `main` branch. 

In this case, we are going to merge the changes from the feature branch `add_default_param` to our `main` branch.

1. Head to the repository Person One created earlier. 
2. Look for, and click on the button: `Compare & pull request`.
3. You now have the opportunity to give your pull request a name and a description. You can add reviewers (see right-hand panel) or mention people in the comments (using the `@` symbol, as in Slack), add attachments and request that a specific person(s) looks at the pull request. 
4. Assign yourself to the PR as it will ensure that you receive a notification if anyone makes a comment.
5. Click `create pull request` and wait for your code to be 'approved'.

### Person One

Depending on the workflow and structure of your team, either Person One or Person Two can perform the merge. For this exercise, we will assume that Person One has responsibility for merging the branches. 

Now that Person Two has created a pull request, Person One can look at these changes on GitHub and merge the pull request.

## Merging a pull request

1. Navigate to the `git_lab` repository on GitHub.
2. Click on `Pull Requests`. You should now see all the pull requests that exist for that repository.
3. Click on the relevant pull request (there will only be one for this lab).
4. (You may need to scroll down to see this) Hopefully you can see that your pull request has a green tick and the label: `This branch has no conflicts with the base branch`. Click on `Merge pull request`.
5. Add a comment to the merge commit message and `Confirm merge`.
6. This new merged code only exists together on GitHub. Both Person One and Person Two should `git checkout main` and `git pull` so that they have the most up-to-date version locally on the their laptops.
7. Person One will now see `Pull request successfully merged and closed` along with the note that the `branch can now be safely deleted`. Click `Delete branch`.

Although you can merge branches directly in the Terminal, pull requests are a more collaborative, controlled and nowadays, more conventional way of merging code.

> You may wish to look at pull requests made on open source projects, such as [`facebook/react`](https://github.com/facebook/react).


## Merging with conflicts

Each person is now going to make a change in the same file and a conflict is going to be created that you will need to handle.
First, Person One will create their own fix branch, make a change and push that change to GitHub. They will then create a pull request for that change, which they will merge on GitHub. This creates a change that Person Two does not have locally.
Person Two will also make a change in the same file, but when they create a pull request, GitHub will note that a conflict needs to be resolved. This part of the exercise will guide you through how to do that.

### Person One

1. Double check you have all the latest changes on `main` - `git pull origin main`.
2. Make your own fix branch (ensure you branch off `main`):
  - Person 1: `fix/implicit_return`,
3. Complete the fix as below:
  - Person 1: Refactor the function to use the arrow function's implicit return
  ```js
  const helloWorld = (name = "World") => `Hello ${name}!`;
  ```
4. Add and push the change to the fix branch.
5. Return to GitHub and [create a pull request](#Creating-a-pull-request) for this branch. 
6. Merge the change into your main branch on GitHub. Delete the branch when prompted (note: this only deletes the branch on GitHub).

### Person Two 

1. For the purposes of this exercise, Person Two **will not** pull these changes as would be normal good practice.
2. Make your own fix branch (ensure you branch off main)
  - Person 2: 'fix/rename_function'.
3. Complete the fix as below:
  - Person 2: Rename the function from `helloWorld` to `greet`.
  ```js
  const greet = (name = "World") => {
    return `Hello ${name}!`;
  }
  ```
4. Add and push the change to the fix branch.
5. Return to GitHub and [create a pull request](#Creating-a-pull-request) for this branch.
6. You will see that GitHub advises that `X can't automatically merge`, but that you can still create the pull request anyway.
7. Once created, you will see that Person Two's pull request notes that `This branch has conflicts that must be resolved`

## Resolving Conflicts
It is often possible to resolve any issues via GitHub. There is a somewhat more complicated workflow which allows you to resolve conflicts in your editor (VS Code), however,  for this lab, we will resolve conflicts via GitHub.

1. Click on the PR you wish to work on. You will see a note that says `This branch has conflicts that must be resolved`. 
2. Click on the `Resolve Conflicts` button, which will take you to an online editor.
3. Decide if you want to keep only your branch's changes, keep only the other branch's changes, or make a brand new change. Delete the conflict markers <<<<<<<, =======, >>>>>>> and make the changes you want in the final merge.
4. Once you've resolved all the conflicts in the file, click `Mark as resolved`.
5. If you have more than one file with a conflict, select the next file you want to edit on the left side of the page under `conflicting files` and repeat the steps above.

You have now resolved your merge conflicts and can merge your branch into `main`!


## Conclusion

You have now followed a work-flow that enabled you to simultaneously have multiple people working on the same project using branches, ensuring that you always have a stable version of the code (on the main branch). This means that at any point in time during development you always have a working application.

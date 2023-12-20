# 🎉・VOLISTIC・🎊

![DeffreusThedaBanner](https://github.com/DeffreusTheda/ComSci/assets/147963726/eb1f6827-0b64-49c4-8686-5c4e2cbe23ab)

Version: 1.1

**Volistic** is an open-source Java project, bundling the programs made by PD`06 in IB Computer Science

Anyone is allowed to give feedback and even contributions, that would be much appreciated 💖

## Prerequisites

### - Download Java Development Kit (JDK)

1. Click [here](https://www.oracle.com/java/technologies/downloads/) to download JDK! (For MacOs: `ARM64 DMG Installer`)
2. Once done, open (run/execute) the JDK installer! (It's probably on your user's `Downloads` folder)
3. Follow through the installation process!

#### Installation Verification

1. Open up your desired terminal application! Default are:
       - 'Terminal' for MacOs & Linux!
       - 'Command Prompt' for Windows!
2. Type `java --version` to verify it!
3. If it's installed, it should be like this:
![Java-verified](https://github.com/DeffreusTheda/ComSci/assets/147963726/752f5d49-01cf-4f87-be2a-33838d471b06)

## How to Contribute

### - Have '[Git](https://git-scm.com/downloads)' installed (Click on the link to go to Git download page)

### Through VSCode (Recommended)

1. Donwload & Install VSCode! See the guide [here](https://www.youtube.com/watch?v=U5swA1GRJ18)!
2. Open VSCode, then click the 'Extension' icon on the side bar!
3. Download the following extensions:

- GitHub Actions by GitHub
- GitHub Pull Requests and Issues by GitHub
- GitLens — Git supercharged (Optional; Highly recommended) by GitHub
- Markdown Preview Github Styling by Matt Bierner (Optional)
- Code Runner by Jun Han
- Code Time by Software (Optional)

- Java Language Support by George Fraser
- Java Run by caolin
- Debugger for Java by Microsoft
- Extension Pack for Java by Microsoft
- Language Support for Java(TM) by Red Hat

#### Link your GitHub Account

1. On the side bar, press the 'Accounts' icon, then press the sign in button!
2. You'll then be redirected to GitHub. Login to your account or create an account if you don't have one!
3. Follow through the instructions given!

#### Cloning the Repository

To work and make changes to the source code, it's recommended to edit in your own local repository than directly on the remote repository through GitHub website. Thus, you need to **clone** the remote repository, making a copy of it locally on your machine.

1. Press `Cmd⌘ + Shift⇧ + P` and type 'Git: Clone'!
2. Choose 'Clone from GitHub'!
3. Type 'PD-06/Volistic' and press `return↵`!
4. Select your preferred folder for the repository! (It's not recommended to put it on the 'Downloads' folder)
5. **Open the cloned repository!** You can now make changes to the code!
6. VSCode will ask if you trust the authors of the files. Check the 'Trust the authors of all files in the parent folder...' and click the 'Yes, I trust the authors' button!
7. Done! You can now edit the files on your local repository!

Tips: if the Java Language Support server crashed, press `Cmd⌘ + Shift⇧ + P` and type 'Java: Restart Java Language Server'!

#### Configuring Git

For pushing commits, git needs your GitHub account's username and email.

1. Open VSCode Terminal --> On the menu bar (top-most bar): Terminal > New Terminal
2. On the terminal, type `git config --global user.name "USERNAME"`, replacing USERNAME with your GitHub username!
3. Type `git config --global user.email "EMAIL"`, replacing EMAIL with your email, e.g `example@gmail.com`!

#### Remember to Frequently Pull

Whenever there's a change in the remote repository, you need to 'pull' that change to your local repository in order to stay up-to-date with remote changes. The 'Source Control' panel wil tell you if there's a change in the remote repository that you need to pull to your local repository.

1. Press `Cmd⌘ + Shift⇧ + P` and type 'Git: Pull', then press `return↵`!

#### Committing & Pushing Changes

When you're making code changes in VSCode, you're editing your local repository. To get your changes to the remote repository, you must 'commit' your changes and 'push' the commit. **Ideally, each commit is small and only discuss one topic of change; don't bundle multiple changes of different topics into one commit!**

1. Go to the 'Source Control' panel from the sidebar!
2. After you saved all your changes, under the 'Changes' dropdown, press `+` beside the **M**odified file that you want to commit!
3. After your changes are staged, under the 'SOURCE CONTROL' dropdown, enter a commit message describing what changes you made!
4. Press `Cmd⌘ + return↵` to send the commit!
5. Finally, 'push' your commit(s) by pressing `Cmd⌘ + Shift⇧ + P` and typing 'Git: Push'

## 🍎・Wanna Try it Out??

There are two version of Volistic currently:

1. Volistic CLI : `Volistic.java`
2. Volistic GUI (Only for Coffee Shop) : `CoffeeShop.java`

The CLI version of Volistic contains 4 programs: Coffee Shop, BMI Calculator, Two Variable Calculator, and Sleep Duration Calculator

As of the current development progress, only Coffee Shop has been imported into GUI

## Downloading & Running Volistic

1. Download the file above: `Volistic.java`! (Just place it on your Downloads folder for convenient sake)
2. Once done, open up `Terminal`, and enter these commands:

       - `cd /Users/USERNAME/Downloads`
       - `javac Volistic.java`
       - `java Volistic`

3. 🎉・It should now run the Volistic Program, have fun!・🎊

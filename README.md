# Grace Script Commands with Application Templates

Grace 2023.0.0 introduces Application Templates, which use [Groovy AntBuilder](http://docs.groovy-lang.org/docs/groovy-4.0.22/html/documentation/#antbuilder) to apply Application Templates.

This project show you how to use `GroovyScriptCommand` `apply()` which added in Grace 2023.0.0.

### Grace Version

* Grace 2023.0.0

### Project Directory

`demoplugin` is a Plugin, includes three script commands:

* demo:install 
* demo:uninstall 
* demo:upgrade 

In the `demoplugin/src/main/scripts/install.groovy`, this command will use template `demoplugin/src/main/resources/demo/Install.groovy`,

```
URL template = DemopluginGrailsPlugin.getResource('/demo/Install.groovy')

apply template
```

These command will apply Application Templates in `demoplugin/src/main/resources/demo/`,

* `Install.groovy`
* `Uninstall.groovy`
* `Upgrade.groovy`

`demoapp` is an Application, dependens on `demoplugin`,

```gradle
dependencies {
    implementation "grace.plugins:demoplugin:0.0.1-SNAPSHOT"
}
```

In `demoapp`, you will see three Script Commands provided by `demoplugin`,

```bash
$ cd demoapp
$ grace help
```

```bash
| Available Commands (type grace help 'command-name' for more info):
| Command Name                          Command Description
----------------------------------------------------------------------------------------------------
demo:install                            Install Demo
demo:uninstall                          Uninstall Demo
demo:upgrade                            Upgrade Demo
```

### How it Works?

```bash
$ cd demoplugin
$ ./gradlew clean pTML
$ cd demoapp

$ grace help
$ grace demo:install 
$ grace demo:uninstall 
$ grace demo:upgrade 
```

If you execute `demo:install`, you will see bellow,

```bash
Install Demo...
| Applying Template
   [groovy] execute script: jar:file:/Users/rain/.m2/repository/grace/plugins/demoplugin/0.0.1-SNAPSHOT/demoplugin-0.0.1-SNAPSHOT-plugin.jar!/demo/Install.groovy
      [say] Install demo from Demo Plugin
      [say] Install Bootstrap and HTMX
     [file] package.json
      [npm] install
      [npm]
      [npm] added 17 packages in 666ms
      [npm]
      [npm] 2 packages are looking for funding
      [npm]   run `npm fund` for details
     [file] .gitignore
      [say] Done.
Done.
```

If you execute `demo:upgrade`, you will see bellow,

```bash
Upgrade Demo...
| Applying Template
   [groovy] execute script: jar:file:/Users/rain/.m2/repository/grace/plugins/demoplugin/0.0.1-SNAPSHOT/demoplugin-0.0.1-SNAPSHOT-plugin.jar!/demo/Upgrade.groovy
      [say] Upgrade demo from Demo Plugin
      [say] Upgrade Bootstrap and HTMX
      [npm] install
      [npm]
      [npm] changed 2 packages in 814ms
      [npm]
      [npm] 2 packages are looking for funding
      [npm]   run `npm fund` for details
      [say] Done.
```

If you execute `demo:uninstall`, you will see bellow,

```bash
Uninstall Demo...
| Applying Template
   [groovy] execute script: jar:file:/Users/rain/.m2/repository/grace/plugins/demoplugin/0.0.1-SNAPSHOT/demoplugin-0.0.1-SNAPSHOT-plugin.jar!/demo/Uninstall.groovy
      [say] Uninstall demo from Demo Plugin
      [say] Uninstall Bootstrap and HTMX
   [delete] Deleting directory /Users/rain/Development/github/grace/grace-demos/grace-script-command-demo/demoapp/node_modules
   [delete] Deleting: /Users/rain/Development/github/grace/grace-demos/grace-script-command-demo/demoapp/package.json
   [delete] Deleting: /Users/rain/Development/github/grace/grace-demos/grace-script-command-demo/demoapp/package-lock.json
      [say] Done.
```

### Summary

Application templates are simple Groovy files containing DSL, Ant tasks, and Groovy scripts, etc.

* you can use templates to generate/customize Grace applications.
* you can write reusable application templates using the Groovy template scripts.

This feature allow script command to apply Application Templates to exist project, perform some complex tasks such as install, uninstall, upgrade.

If you are Plugin developer, this will help you use powerful Groovy scripts to provide commands and tasks for the end users,

so users will easily install your plugins and configure it.

### Links

* [Application Templates](https://github.com/graceframework/grace-framework/issues/406)
* [Support Command can be hidden](https://github.com/graceframework/grace-framework/issues/409)
* [Namespaced Command](https://github.com/graceframework/grace-framework/issues/410)
* [Allow Command to be deprecated](https://github.com/graceframework/grace-framework/issues/411)
* [Refine GroovyScriptCommand](https://github.com/graceframework/grace-framework/issues/413)

ant.say 'Uninstall demo from Demo Plugin'

ant.sequential {
    say "Uninstall Bootstrap and HTMX"

    delete(dir: 'node_modules')
    delete(file: 'package.json')
    delete(file: 'package-lock.json')
    replace(file: '.gitignore') {
        replacetoken 'node_modules'
        replacevalue ''
    }
}

ant.say 'Done.'

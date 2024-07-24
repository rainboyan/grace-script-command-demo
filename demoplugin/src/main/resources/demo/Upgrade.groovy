ant.say 'Upgrade demo from Demo Plugin'

ant.sequential {
    say "Upgrade Bootstrap and HTMX"

    replace(file: 'package.json') {
        replacetoken '^5.1.3'
        replacevalue '^5.3.3'
    }
    replace(file: 'package.json') {
        replacetoken '^1.9.10'
        replacevalue '^2.0.1'
    }
    npm("install")
}

ant.say 'Done.'

ant.say 'Install demo from Demo Plugin'

ant.sequential {
    say "Install Bootstrap and HTMX"

    file(name: 'package.json', '''
{
    "private": true,
    "dependencies": {
        "bootstrap": "^5.1.3",
        "htmx.org": "^1.9.10",
        "hyperscript.org": "^0.9.12"
    }
}
''')
    npm("install")
    file(name: ".gitignore", append: 'yes', 'node_modules')
}

ant.say 'Done.'

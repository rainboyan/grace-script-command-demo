import grace.plugins.DemopluginGrailsPlugin

namespace 'demo'
description "Install Demo", "grace demo:install"

println "Install Demo..."

URL template = DemopluginGrailsPlugin.getResource('/demo/Install.groovy')

apply template

println 'Done.'

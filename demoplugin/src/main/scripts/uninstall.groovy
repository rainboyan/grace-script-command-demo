import grace.plugins.DemopluginGrailsPlugin

namespace 'demo'
description "Uninstall Demo", "grace demo:uninstall"

println "Uninstall Demo..."

URL template = DemopluginGrailsPlugin.getResource('/demo/Uninstall.groovy')

apply template

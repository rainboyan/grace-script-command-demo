import grace.plugins.DemopluginGrailsPlugin

namespace 'demo'
description "Upgrade Demo", "grace demo:upgrade"

println "Upgrade Demo..."

URL template = DemopluginGrailsPlugin.getResource('/demo/Upgrade.groovy')

apply template

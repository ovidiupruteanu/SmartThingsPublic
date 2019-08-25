/**
 *  Switch Counter
 */
definition(
    name: "Switch Counter",
    namespace: "ovidiupruteanu",
    author: "Ovidiu Pruteanu",
    description: "Keeps track of how many time a switch is turned on",
    category: "Convenience",
    iconUrl: "https://github.com/chancsc/icon/raw/master/standard-tile%401x.png",
    iconX2Url: "https://github.com/chancsc/icon/raw/master/standard-tile@2x.png",
    iconX3Url: "https://github.com/chancsc/icon/raw/master/standard-tile@3x.png")

preferences {
    section() {
        input "theswitch", "capability.switch"
    }
}

def installed() {
    initialize()
}

def updated() {
    unsubscribe()
    initialize()
}

def initialize() {
    // initialize counter
    state.switchCounter = 0

    subscribe(theswitch, "switch.on", incrementCounter)
}

def incrementCounter(evt) {
    state.switchCounter = state.switchCounter + 1
    log.debug "switch has been turned on $state.switchCounter times"
}
class SecurityFilters {
    def filters = {
        doLogin(controller: '*', action: '*') {
            before = {

                if (!controllerName) {
                    return true
                }

                def allowedActions = ['show', 'index', 'login', 'validate', 'search']

                if (!session.user && !allowedActions.contains(actionName)) {
                    redirect(controller: 'tekUser', action: 'login',params:['cName': controllerName, 'aName': actionName])
                    return false
                }
            }

        }
        doLog(controller: '*', action: '*') {
            before = {
                println "Controller: ${controllerName} => action: ${actionName}"
            }
        }
    }
}
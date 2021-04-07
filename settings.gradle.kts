rootProject.name = "oneforall"

fun includeProject(path: String, name: String = path): ProjectDescriptor {
    include(path)
    return project(":$path").apply {
        this.name = name
    }
}

includeProject("server")
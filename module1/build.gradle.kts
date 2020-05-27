import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.jvm.tasks.Jar

plugins {
	id("org.springframework.boot") version "2.2.6.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	kotlin("jvm") version "1.3.71"
	kotlin("plugin.spring") version "1.3.71"
	id("com.google.cloud.tools.jib") version "1.8.0"
}

group = "com.brainzbytes"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	api(project(":library"))
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Jar> {
	enabled = true
}

jib {
//    from.image = "adoptopenjdk/openjdk12:x86_64-alpine-jdk-12.0.2_10"
	to.image = "apunreddy/test1:latest"
        to.auth.username="apunreddy"
        to.auth.password="A@sand0421"

//	container.environment = mapOf("SPRING_PROFILES_ACTIVE" to "testing", "JDBC_URL" to "postgres:5432/flyway")
}

tasks.bootRun {
//	environment("SPRING_PROFILES_ACTIVE","testing, efgh")
}

val fatJar = task("fatJar", type = Jar::class) {
	baseName = "${project.name}-fat"
	// manifest Main-Class attribute is optional.
	// (Used only to provide default main class for executable jar)
	manifest {
		attributes["Main-Class"] = "com.brainzbytes.module1.Module1Application" // fully qualified class name of default main class
	}
//	from(configurations.runtime.map({ if (it.isDirectory) it else zipTree(it) }))
	with(tasks["jar"] as CopySpec)
}

tasks {
	"build" {
		dependsOn(fatJar)
	}
}

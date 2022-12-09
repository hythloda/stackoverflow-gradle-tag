// Add next to your module gradle (Not the app gradle file):

repositories {
   flatDir {
       dirs("libs")
   }
}



dependencies {
   implementation("gson-2.2.4")
}

// However, being a standard .jar in an actual maven repository, why don't you try this?

repositories {
   mavenCentral()
}
dependencies {
   implementation ("com.google.code.gson:gson:2.2.4")
}

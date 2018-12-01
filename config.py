app_id = 'net.ltslab.games.sud'

def can_build(env, platform):
    return platform == 'android'

def configure(env):
    if env['platform'] == 'android':
        env.android_add_gradle_classpath('com.google.gms:google-services:4.1.0')
        env.android_add_java_dir('android')
        env.android_add_res_dir('res')
        env.android_add_to_manifest('android/AndroidManifestChunk.xml')
        env.android_add_to_permissions('android/AndroidPermissionsChunk.xml')
        env.android_add_default_config("applicationId '"+app_id+"'")
        env.android_add_dependency("implementation 'com.google.firebase:firebase-core:16.0.5'")
        env.android_add_dependency("implementation 'com.google.firebase:firebase-database:16.0.5'")
        env.android_add_dependency("implementation 'com.google.firebase:firebase-messaging:17.3.4'")
        env.android_add_dependency("implementation 'com.google.firebase:firebase-config:16.1.0'")
        env.android_add_dependency("implementation 'com.google.firebase:firebase-invites:16.0.5'")
        env.android_add_dependency("implementation 'com.google.firebase:firebase-ads:17.1.1'")
        env.android_add_gradle_plugin('com.google.gms.google-services')
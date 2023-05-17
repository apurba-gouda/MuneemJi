package com.app.di.app

import dagger.Component

@Component(modules = [FeatureModule::class])
interface FeatureComponent {
    //expose your dependencies here

}

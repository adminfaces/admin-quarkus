package com.github.adminfaces.quarkus.extension.deployment;

import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.nativeimage.NativeImageResourceBuildItem;
import io.quarkus.deployment.builditem.nativeimage.NativeImageResourceBundleBuildItem;

public class AdminFacesProcessor {

    @BuildStep
    void substrateResourceBuildItems(BuildProducer<NativeImageResourceBuildItem> nativeImageResourceProducer,
            BuildProducer<NativeImageResourceBundleBuildItem> resourceBundleBuildItem) {
        resourceBundleBuildItem
                .produce(new NativeImageResourceBundleBuildItem("com.github.adminfaces.template.i18n.AdminUTF8Bundle"));
    }
}

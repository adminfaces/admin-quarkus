package com.github.adminfaces.quarkus.extension.deployment;

import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.AdditionalApplicationArchiveMarkerBuildItem;
import io.quarkus.deployment.builditem.CombinedIndexBuildItem;
import io.quarkus.deployment.builditem.nativeimage.ReflectiveClassBuildItem;

public class PrimeFacesExtensionProcessor {

    @BuildStep
    void produceApplicationArchiveMarker(
            BuildProducer<AdditionalApplicationArchiveMarkerBuildItem> additionalArchiveMarkers) {
        additionalArchiveMarkers
                .produce(new AdditionalApplicationArchiveMarkerBuildItem("org/primefaces/extensions/component"));
        additionalArchiveMarkers.produce(new AdditionalApplicationArchiveMarkerBuildItem("org/primefaces/extensions/behavior"));
        additionalArchiveMarkers.produce(new AdditionalApplicationArchiveMarkerBuildItem("org/primefaces/extensions/util"));
    }

    @BuildStep
    void registerForReflection(BuildProducer<ReflectiveClassBuildItem> reflectiveClass,
            CombinedIndexBuildItem combinedIndex) {
        reflectiveClass.produce(new ReflectiveClassBuildItem(false, false,
                "org.primefaces.extensions.component.codemirror.CodeMirrorHandler",
                "org.primefaces.extensions.behavior.javascript.JavascriptBehaviorHandler",
                "org.primefaces.extensions.component.parameters.AssignableParameterHandler",
                "org.primefaces.extensions.component.parameters.MethodSignatureTagHandler",
                "org.primefaces.extensions.component.exporter.ExporterTagHandler"));

        reflectiveClass.produce(new ReflectiveClassBuildItem(true, false,
                "org.apache.commons.lang3.StringEscapeUtils", "org.primefaces.extensions.util.URLEncoderWrapper",
                "org.primefaces.extensions.component.remotecommand.RemoteCommandHandler",
                "org.primefaces.extensions.util.ComponentUtils"));
    }
}

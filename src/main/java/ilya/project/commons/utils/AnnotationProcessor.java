package ilya.project.commons.utils;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

@SupportedAnnotationTypes("ilya.project.commons.utils.Unstable")
public class AnnotationProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(Unstable.class)) {
            processingEnv.getMessager().printMessage(
                    Diagnostic.Kind.WARNING,
                    "Part of code " + element.getSimpleName() + " is marked as @Unstable and may change in the future.",
                    element
            );
        }
        return true;
    }

}

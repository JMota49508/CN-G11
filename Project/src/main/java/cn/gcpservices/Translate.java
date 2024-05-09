package cn.gcpservices;

import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import java.util.ArrayList;
import java.util.List;

public class Translate {
    public static List<String> translateLabels(List<String> labels, String sourceLanguage, String targetLanguage) {
        List<java.lang.String> labelsTranslated = null;
        try {
            com.google.cloud.translate.Translate translateService = TranslateOptions.getDefaultInstance().getService();
            labelsTranslated = new ArrayList<>();
            for (java.lang.String label : labels) {
                Translation translation = translateService.translate(
                        label,
                        com.google.cloud.translate.Translate.TranslateOption.sourceLanguage(sourceLanguage),
                        com.google.cloud.translate.Translate.TranslateOption.targetLanguage(targetLanguage));
                labelsTranslated.add(translation.getTranslatedText());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return labelsTranslated;
        }
    }

    public static String translateLine(String line, String sourceLanguage, String targetLanguage) {
        com.google.cloud.translate.Translate translateService = TranslateOptions.getDefaultInstance().getService();
        Translation translation = translateService.translate(
                line.toLowerCase(),
                com.google.cloud.translate.Translate.TranslateOption.sourceLanguage(sourceLanguage),
                com.google.cloud.translate.Translate.TranslateOption.targetLanguage(targetLanguage));
        return translation.getTranslatedText();
    }
}

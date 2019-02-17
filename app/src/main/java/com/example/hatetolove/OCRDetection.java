package com.example.hatetolove;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer;

public class OCRDetection {

    public static FirebaseVisionImage getBitmapImage(Bitmap image){
        FirebaseVisionImage imageFire = FirebaseVisionImage.fromBitmap(image);
        return imageFire;
    }
    public static void recognizeText(FirebaseVisionImage image) {

        // [START get_detector_default]
        FirebaseVisionTextRecognizer detector = FirebaseVision.getInstance()
                .getOnDeviceTextRecognizer();
        // [END get_detector_default]

        // [START run_detector]
        Task<FirebaseVisionText> result =
                detector.processImage(image)
                        .addOnSuccessListener(new OnSuccessListener<FirebaseVisionText>() {
                            @Override
                            public void onSuccess(FirebaseVisionText firebaseVisionText) {
                                // Task completed successfully
                                // [START_EXCLUDE]
                                // [START get_text]
                                for (FirebaseVisionText.TextBlock block : firebaseVisionText.getTextBlocks()) {
                                    String text = block.getText();
                                    Log.d("FireBase_","Detected text = " + text);
//                                    for (FirebaseVisionText.Line line: block.getLines()) {
//                                        // ...
//                                        for (FirebaseVisionText.Element element: line.getElements()) {
//                                            // ...
//                                        }
//                                    }
                                }
                                // [END get_text]
                                // [END_EXCLUDE]
                            }
                        })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        // Task failed with an exception
                                        // ...
                                        Log.e("ERROR_IN_FIREBASE",e.getMessage());
                                    }
                                });
        // [END run_detector]
    }

    private static void processTextBlock(FirebaseVisionText result) {
        // [START mlkit_process_text_block]
        String resultText = result.getText();
        Log.d("PROCESS_BLOCK_RESULT_TEXT",resultText);
        for (FirebaseVisionText.TextBlock block: result.getTextBlocks()) {
            String blockText = block.getText();
            Log.d("PROCESS_BLOCK_BLOCK_TEXT",blockText);
            //Float blockConfidence = block.getConfidence();
            for (FirebaseVisionText.Line line: block.getLines()) {
                String lineText = line.getText();
                //Float lineConfidence = line.getConfidence();
                Log.d("PROCESS_BLOCK_line_TEXT",lineText);
                for (FirebaseVisionText.Element element: line.getElements()) {
                    String elementText = element.getText();
                    Log.d("PROCESS_BLOCK_element_TEXT",elementText);
                    //Float elementConfidence = element.getConfidence();

                }
            }
        }
        // [END mlkit_process_text_block]
    }
}

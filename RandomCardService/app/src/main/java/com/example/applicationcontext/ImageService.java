package com.example.applicationcontext;

import android.content.res.Resources;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class ImageService {

    private static List<Field> createListField() {

        Field[] imageDrawables = R.drawable.class.getDeclaredFields();

        List<Field> resultImages = new ArrayList<>();
        for (Field field : imageDrawables) {
            if (field.getName().startsWith("card")) {
                resultImages.add(field);
            }
        }
        return resultImages;
    }

    public static int randomizeImage() {

        List<Field> fieldList = createListField();

        Resources resource = App.getContext().getResources();

        String packageName = App.getContext().getPackageName();

        Random random = new Random();

        String fieldName = fieldList.get(random.nextInt(fieldList.size())).getName();

        return resource.getIdentifier(fieldName, "drawable", packageName);
    }
}

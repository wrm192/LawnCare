package com.redflag.lawncare.common.models;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

public class ImageInstanceCreator implements InstanceCreator<Image> {
    @Override
    public Image createInstance(Type type){
        return new Image( );
    }
}

///gsonBuilder.registerTypeAdapter(Image.class, new ImageInstanceCreator());
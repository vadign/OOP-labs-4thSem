package com.nsu.ccfit;

import com.nsu.ccfit.options.Option;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class Factory {

    private final Properties properties = new Properties();
    private static Factory myFactory = null;

    private Factory() throws IOException {
        var input = Factory.class.getResourceAsStream("options.properties");

        if (input != null) {
            properties.load(input);
            input.close();
        }

    }

    public static Factory getInstance() throws IOException {


        if (myFactory == null) {
            synchronized (Factory.class){
                if(myFactory == null){
                    myFactory = new Factory();
                }
            }
        }

        return myFactory;
    }

    public Option createOption(String optionName) throws Exception {
        Option currentOption;
        var classOfOption = Class.forName(properties.getProperty(optionName));
        var objectInstance = classOfOption.getDeclaredConstructor().newInstance();
        currentOption = (Option) objectInstance;
        return currentOption;
    }

}

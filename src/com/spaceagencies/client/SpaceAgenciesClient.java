package com.spaceagencies.client;

import java.lang.reflect.Field;

import javax.swing.UIManager;

import com.spaceagencies.common.tools.Log;
import com.spaceagencies.server.ParameterAnalyser;

public class SpaceAgenciesClient {

    public static void main(String[] args) {
        Log.perfBegin("Init");

        if(System.getProperty("os.name").equals("Linux")) {
            System.setProperty( "java.library.path", "lib/lwjgl/native/linux");
        } else if(System.getProperty("os.name").startsWith("Windows")) {
            System.setProperty( "java.library.path", "lib/lwjgl/native/windows");
        } else if(System.getProperty("os.name").startsWith("Mac")) {
            System.setProperty( "java.library.path", "lib/lwjgl/native/macosx");
        } else {
            System.err.println("Unknown system type: "+System.getProperty("os.name"));
        }
        
        Field fieldSysPath;
        try {
            fieldSysPath = ClassLoader.class.getDeclaredField( "sys_paths" );
        
        fieldSysPath.setAccessible( true );
        fieldSysPath.set( null, null );
        
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        
        
//        Log.perfBegin("Set LookAndFeel");
//        setLookAndFeel();
//        Log.perfEnd(); // SetLookAndFeel

        // Init static game client
        Log.perfBegin("Init ParameterAnalyser");
        ParameterAnalyser parameterAnalyser = new ParameterAnalyser(args);
        Log.perfEnd(); // ParameterAnalyser
        
        Log.perfBegin("Init GameClient");
        GameClient gameClient = new GameClient(parameterAnalyser);
        Log.perfEnd(); // GameClient
        
        
        Log.perfEnd();
        gameClient.run();

    }

    private static void setLookAndFeel() {
        for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(laf.getName())) {
                try {
                    UIManager.setLookAndFeel(laf.getClassName());

                } catch (Exception e) {
                    // TODO: handle exception
                }

            }
        }
    }

}

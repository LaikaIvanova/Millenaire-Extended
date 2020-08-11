/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  org.apache.commons.io.IOUtils
 *  org.apache.logging.log4j.Logger
 */
package com.laikaivanova.millenaireextended.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import org.apache.commons.io.IOUtils;

import com.laikaivanova.millenaireextended.MillenaireExtended;

public class ContentDeployer {
    private static final String DEV_VERSION_NUMBER = "1.4.0-DEV";

    private static void copyFolder(String modJarPath, String deployLocation, String folder, File destDir) throws URISyntaxException, IOException {
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        JarFile file = new JarFile(modJarPath);
        Enumeration<JarEntry> e = file.entries();
        while (e.hasMoreElements()) {
            JarEntry entry = e.nextElement();
            String jarEntryName = entry.getName();
            if (!jarEntryName.startsWith(deployLocation + folder)) continue;
            File destination = new File(destDir, jarEntryName.substring(deployLocation.length(), jarEntryName.length()));
            if (entry.isDirectory()) {
                destination.mkdirs();
                continue;
            }
            InputStream stream = file.getInputStream(entry);
            FileOutputStream out = new FileOutputStream(destination);
            IOUtils.copy((InputStream)stream, (OutputStream)out);
            stream.close();
            ((OutputStream)out).close();
        }
        file.close();
    }

    public static void deployContent(File ourJar) {
        if (!ContentDeployer.class.getResource("ContentDeployer.class").toString().startsWith("jar")) {
        	MillenaireExtended.LOGGER.warn("ME: No need to redeploy Mill\u00e9naire Extended as we are in a dev environement.");
            return;
        }
        File modsDir = MillCommonUtilities.getModsDir();
        try {
            boolean redeployMillenaire = false;
            File millenaireCustomDir = new File(modsDir, "millenaire-custom");
            if ("1.4.0".equals(DEV_VERSION_NUMBER)) {
                redeployMillenaire = true;
                MillenaireExtended.LOGGER.warn("ME: Deploying millenaire extended / as we are using a dev version and can't test whether it has changed.");
            } else if (!millenaireCustomDir.exists()) {
                redeployMillenaire = true;
                MillenaireExtended.LOGGER.warn("ME: Deploying millenaire extended / to version 1.4.0 as it can't be found.");
            } else {
                File versionFile = new File(millenaireCustomDir, "version.txt");
                if (!versionFile.exists()) {
                    redeployMillenaire = true;
                    //MillCommonUtilities.deleteDir(millenaireCustomDir); - Don't reactivate or else directory gets deleted
                    MillenaireExtended.LOGGER.warn("ME: Redeploying millenaire extended normans/ to version 1.4.0 as it has no version file.");
                } else {
                    BufferedReader reader = MillCommonUtilities.getReader(versionFile);
                    String versionString = reader.readLine();
                    if (!versionString.equals("1.4.0")) {
                        redeployMillenaire = true;
                        //MillCommonUtilities.deleteDir(millenaireCustomDir); - Don't reactivate or else directory gets deleted
                        MillenaireExtended.LOGGER.warn("ME: Redeploying millenaire extended normans/ to version 1.4.0 as it has version " + versionString + ".");
                    } else {
                    	MillenaireExtended.LOGGER.warn("ME: No need to redeploy millenaire extended normans as the millenaire extended folder is already at version " + versionString + ".");
                    }
                }
            }
            if (redeployMillenaire) {
                try {
                    long startTime = System.currentTimeMillis();
                    ContentDeployer.copyFolder(ourJar.getAbsolutePath(), "todeploy/", "millenaire-custom/", modsDir);
                    Files.write(Paths.get(modsDir.getAbsolutePath() + "/millenaire-custom/mods/millenaireextended/version.txt", new String[0]), "1.4.0".getBytes(), new OpenOption[0]);
                    MillenaireExtended.LOGGER.warn("ME: Deployed millenaire-custom folder in " + (System.currentTimeMillis() - startTime) + " ms.");
                }
                catch (IOException e) {
                	MillenaireExtended.LOGGER.error("ME: Error when checking existing millenaire-custom dir: ", (Throwable)e);
                }
            }
        }
        catch (Exception e) {
        	MillenaireExtended.LOGGER.error("ME: Error when unzipping millenaire: ", (Throwable)e);
        }
        
    }
}


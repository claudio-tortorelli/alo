package claudiosoft.test;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;

/**
 *
 * @author claudio.tortorelli
 */
public class TestJar {

    private static BasicLogger logger;
    private static String param;

    public static void main(String[] args) throws CTException, IOException {
        String ver = Version.getVersion();

        BasicLogger.LogLevel logLevel = BasicLogger.LogLevel.NORMAL;
        logger = BasicLogger.get(logLevel, Constants.LOGGER_NAME, new File("./TestJar.log"));

        logger.info("-------------------------------------");
        logger.info("  TestJar " + ver);
        logger.info("-------------------------------------");

        Runtime runtimeEnv = Runtime.getRuntime();
        String osArch = System.getProperty("os.arch");
        String osName = System.getProperty("os.name");
        String osVersion = System.getProperty("os.version");
        String homeDir = System.getProperty("user.home");
        String javaHome = System.getProperty("java.home");
        String javaVer = System.getProperty("java.version");
        String tmpDir = System.getProperty("java.io.tmpdir");
        int nProc = runtimeEnv.availableProcessors();
        long diskSize = new File("/").getTotalSpace();
        long ram = ((com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getTotalMemorySize();

        logger.info(String.format("- operating system name: %s", osName));
        logger.info(String.format("- operating system arch: %s", osArch));
        logger.info(String.format("- operation System version: %s", osVersion));
        logger.info(String.format("- user home: %s", homeDir));
        logger.info(String.format("- processors available: %d", nProc));
        logger.info(String.format("- disk size: %d mb", diskSize / (1024 * 1024)));
        logger.info(String.format("- total ram available: %d mb", ram / (1024 * 1024)));
        logger.info(String.format("- java home: %s", javaHome));
        logger.info(String.format("- java version: %s", javaVer));
        logger.info(String.format("- java temp dir: %s", tmpDir));

        if (args.length > 0) {
            logger.info("...and you passed those arguments");
            for (int i = 0; i < args.length; i++) {
                logger.info(" - " + args[i].trim().toLowerCase());
            }
        }

    }

}

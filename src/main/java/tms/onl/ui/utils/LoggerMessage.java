package tms.onl.ui.utils;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class LoggerMessage {

    private static final String INFO_START_MESSAGE = "[%s] starts";
    private static final String INFO_END_MESSAGE = "[%s] ends";

    public static void logStartProcessInfo(String processName) {
        log.info(String.format(INFO_START_MESSAGE, processName));
    }

    public static void logEndProcessInfo(String processName) {
        log.info(String.format(INFO_END_MESSAGE, processName));
    }
}

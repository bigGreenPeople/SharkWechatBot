package com.shark.input.model;

public class Input {
    public static int AMETA_NONE = 0;
    public static int AMETA_ALT_ON = 0x02;
    public static int AMETA_ALT_LEFT_ON = 0x10;
    public static int AMETA_ALT_RIGHT_ON = 0x20;
    public static int AMETA_SHIFT_ON = 0x01;
    public static int AMETA_SHIFT_LEFT_ON = 0x40;
    public static int AMETA_SHIFT_RIGHT_ON = 0x80;
    public static int AMETA_SYM_ON = 0x04;
    public static int AMETA_FUNCTION_ON = 0x08;
    public static int AMETA_CTRL_ON = 0x1000;
    public static int AMETA_CTRL_LEFT_ON = 0x2000;
    public static int AMETA_CTRL_RIGHT_ON = 0x4000;
    public static int AMETA_META_ON = 0x10000;
    public static int AMETA_META_LEFT_ON = 0x20000;
    public static int AMETA_META_RIGHT_ON = 0x40000;
    public static int AMETA_CAPS_LOCK_ON = 0x100000;
    public static int AMETA_NUM_LOCK_ON = 0x200000;
    public static int AMETA_SCROLL_LOCK_ON = 0x400000;

    public static int AINPUT_EVENT_TYPE_KEY = 1;
    public static int AINPUT_EVENT_TYPE_MOTION = 2;

    public static int AKEY_EVENT_ACTION_DOWN = 0;
    public static int AKEY_EVENT_ACTION_UP = 1;
    public static int AKEY_EVENT_ACTION_MULTIPLE = 2;

    public static int AKEY_EVENT_FLAG_WOKE_HERE = 0x1;
    public static int AKEY_EVENT_FLAG_SOFT_KEYBOARD = 0x2;
    public static int AKEY_EVENT_FLAG_KEEP_TOUCH_MODE = 0x4;
    public static int AKEY_EVENT_FLAG_FROM_SYSTEM = 0x8;
    public static int AKEY_EVENT_FLAG_EDITOR_ACTION = 0x10;
    public static int AKEY_EVENT_FLAG_CANCELED = 0x20;
    public static int AKEY_EVENT_FLAG_VIRTUAL_HARD_KEY = 0x40;
    public static int AKEY_EVENT_FLAG_LONG_PRESS = 0x80;
    public static int AKEY_EVENT_FLAG_CANCELED_LONG_PRESS = 0x100;
    public static int AKEY_EVENT_FLAG_TRACKING = 0x200;
    public static int AKEY_EVENT_FLAG_FALLBACK = 0x400;

    public static int AMOTION_EVENT_ACTION_MASK = 0xff;
    public static int AMOTION_EVENT_ACTION_POINTER_INDEX_MASK = 0xff00;
    public static int AMOTION_EVENT_ACTION_DOWN = 0;
    public static int AMOTION_EVENT_ACTION_UP = 1;
    public static int AMOTION_EVENT_ACTION_MOVE = 2;
    public static int AMOTION_EVENT_ACTION_CANCEL = 3;
    public static int AMOTION_EVENT_ACTION_OUTSIDE = 4;
    public static int AMOTION_EVENT_ACTION_POINTER_DOWN = 5;
    public static int AMOTION_EVENT_ACTION_POINTER_UP = 6;
    public static int AMOTION_EVENT_ACTION_HOVER_MOVE = 7;
    public static int AMOTION_EVENT_ACTION_SCROLL = 8;
    public static int AMOTION_EVENT_ACTION_HOVER_ENTER = 9;
    public static int AMOTION_EVENT_ACTION_HOVER_EXIT = 10;
    public static int AMOTION_EVENT_ACTION_BUTTON_PRESS = 11;
    public static int AMOTION_EVENT_ACTION_BUTTON_RELEASE = 12;

    public static int AMOTION_EVENT_FLAG_WINDOW_IS_OBSCURED = 0x1;

    public static int AMOTION_EVENT_EDGE_FLAG_NONE = 0;
    public static int AMOTION_EVENT_EDGE_FLAG_TOP = 0x01;
    public static int AMOTION_EVENT_EDGE_FLAG_BOTTOM = 0x02;
    public static int AMOTION_EVENT_EDGE_FLAG_LEFT = 0x04;
    public static int AMOTION_EVENT_EDGE_FLAG_RIGHT = 0x08;


    public static int AMOTION_EVENT_AXIS_X = 0;
    public static int AMOTION_EVENT_AXIS_Y = 1;
    public static int AMOTION_EVENT_AXIS_PRESSURE = 2;
    public static int AMOTION_EVENT_AXIS_SIZE = 3;
    public static int AMOTION_EVENT_AXIS_TOUCH_MAJOR = 4;
    public static int AMOTION_EVENT_AXIS_TOUCH_MINOR = 5;
    public static int AMOTION_EVENT_AXIS_TOOL_MAJOR = 6;
    public static int AMOTION_EVENT_AXIS_TOOL_MINOR = 7;
    public static int AMOTION_EVENT_AXIS_ORIENTATION = 8;
    public static int AMOTION_EVENT_AXIS_VSCROLL = 9;
    public static int AMOTION_EVENT_AXIS_HSCROLL = 10;
    public static int AMOTION_EVENT_AXIS_Z = 11;
    public static int AMOTION_EVENT_AXIS_RX = 12;
    public static int AMOTION_EVENT_AXIS_RY = 13;
    public static int AMOTION_EVENT_AXIS_RZ = 14;
    public static int AMOTION_EVENT_AXIS_HAT_X = 15;
    public static int AMOTION_EVENT_AXIS_HAT_Y = 16;
    public static int AMOTION_EVENT_AXIS_LTRIGGER = 17;
    public static int AMOTION_EVENT_AXIS_RTRIGGER = 18;
    public static int AMOTION_EVENT_AXIS_THROTTLE = 19;
    public static int AMOTION_EVENT_AXIS_RUDDER = 20;
    public static int AMOTION_EVENT_AXIS_WHEEL = 21;
    public static int AMOTION_EVENT_AXIS_GAS = 22;
    public static int AMOTION_EVENT_AXIS_BRAKE = 23;
    public static int AMOTION_EVENT_AXIS_DISTANCE = 24;
    public static int AMOTION_EVENT_AXIS_TILT = 25;
    public static int AMOTION_EVENT_AXIS_SCROLL = 26;
    public static int AMOTION_EVENT_AXIS_RELATIVE_X = 27;
    public static int AMOTION_EVENT_AXIS_RELATIVE_Y = 28;
    public static int AMOTION_EVENT_AXIS_GENERIC_1 = 32;
    public static int AMOTION_EVENT_AXIS_GENERIC_2 = 33;
    public static int AMOTION_EVENT_AXIS_GENERIC_3 = 34;
    public static int AMOTION_EVENT_AXIS_GENERIC_4 = 35;
    public static int AMOTION_EVENT_AXIS_GENERIC_5 = 36;
    public static int AMOTION_EVENT_AXIS_GENERIC_6 = 37;
    public static int AMOTION_EVENT_AXIS_GENERIC_7 = 38;
    public static int AMOTION_EVENT_AXIS_GENERIC_8 = 39;
    public static int AMOTION_EVENT_AXIS_GENERIC_9 = 40;
    public static int AMOTION_EVENT_AXIS_GENERIC_10 = 41;
    public static int AMOTION_EVENT_AXIS_GENERIC_11 = 42;
    public static int AMOTION_EVENT_AXIS_GENERIC_12 = 43;
    public static int AMOTION_EVENT_AXIS_GENERIC_13 = 44;
    public static int AMOTION_EVENT_AXIS_GENERIC_14 = 45;
    public static int AMOTION_EVENT_AXIS_GENERIC_15 = 46;
    public static int AMOTION_EVENT_AXIS_GENERIC_16 = 47;

    public static int AMOTION_EVENT_BUTTON_PRIMARY = 1 << 0;
    public static int AMOTION_EVENT_BUTTON_SECONDARY = 1 << 1;
    public static int AMOTION_EVENT_BUTTON_TERTIARY = 1 << 2;
    public static int AMOTION_EVENT_BUTTON_BACK = 1 << 3;
    public static int AMOTION_EVENT_BUTTON_FORWARD = 1 << 4;
    public static int AMOTION_EVENT_BUTTON_STYLUS_PRIMARY = 1 << 5;
    public static int AMOTION_EVENT_BUTTON_STYLUS_SECONDARY = 1 << 6;

    public static int AMOTION_EVENT_TOOL_TYPE_UNKNOWN = 0;
    public static int AMOTION_EVENT_TOOL_TYPE_FINGER = 1;
    public static int AMOTION_EVENT_TOOL_TYPE_STYLUS = 2;
    public static int AMOTION_EVENT_TOOL_TYPE_MOUSE = 3;
    public static int AMOTION_EVENT_TOOL_TYPE_ERASER = 4;

    public static int AINPUT_SOURCE_CLASS_MASK = 0x000000ff;
    public static int AINPUT_SOURCE_CLASS_NONE = 0x00000000;
    public static int AINPUT_SOURCE_CLASS_BUTTON = 0x00000001;
    public static int AINPUT_SOURCE_CLASS_POINTER = 0x00000002;
    public static int AINPUT_SOURCE_CLASS_NAVIGATION = 0x00000004;
    public static int AINPUT_SOURCE_CLASS_POSITION = 0x00000008;
    public static int AINPUT_SOURCE_CLASS_JOYSTICK = 0x00000010;

    public static int AINPUT_SOURCE_UNKNOWN = 0x00000000;
    public static int AINPUT_SOURCE_KEYBOARD = 0x00000100 | AINPUT_SOURCE_CLASS_BUTTON;
    public static int AINPUT_SOURCE_DPAD = 0x00000200 | AINPUT_SOURCE_CLASS_BUTTON;
    public static int AINPUT_SOURCE_GAMEPAD = 0x00000400 | AINPUT_SOURCE_CLASS_BUTTON;
    public static int AINPUT_SOURCE_TOUCHSCREEN = 0x00001000 | AINPUT_SOURCE_CLASS_POINTER;
    public static int AINPUT_SOURCE_MOUSE = 0x00002000 | AINPUT_SOURCE_CLASS_POINTER;
    public static int AINPUT_SOURCE_STYLUS = 0x00004000 | AINPUT_SOURCE_CLASS_POINTER;
    public static int AINPUT_SOURCE_BLUETOOTH_STYLUS = 0x00008000 | AINPUT_SOURCE_STYLUS;
    public static int AINPUT_SOURCE_TRACKBALL = 0x00010000 | AINPUT_SOURCE_CLASS_NAVIGATION;
    public static int AINPUT_SOURCE_MOUSE_RELATIVE = 0x00020000 | AINPUT_SOURCE_CLASS_NAVIGATION;
    public static int AINPUT_SOURCE_TOUCHPAD = 0x00100000 | AINPUT_SOURCE_CLASS_POSITION;
    public static int AINPUT_SOURCE_TOUCH_NAVIGATION = 0x00200000 | AINPUT_SOURCE_CLASS_NONE;
    public static int AINPUT_SOURCE_JOYSTICK = 0x01000000 | AINPUT_SOURCE_CLASS_JOYSTICK;
    public static int AINPUT_SOURCE_ROTARY_ENCODER = 0x00400000 | AINPUT_SOURCE_CLASS_NONE;

    public static int AINPUT_KEYBOARD_TYPE_NONE = 0;
    public static int AINPUT_KEYBOARD_TYPE_NON_ALPHABETIC = 1;
    public static int AINPUT_KEYBOARD_TYPE_ALPHABETIC = 2;

    public static int AINPUT_MOTION_RANGE_X = AMOTION_EVENT_AXIS_X;
    public static int AINPUT_MOTION_RANGE_Y = AMOTION_EVENT_AXIS_Y;
    public static int AINPUT_MOTION_RANGE_PRESSURE = AMOTION_EVENT_AXIS_PRESSURE;
    public static int AINPUT_MOTION_RANGE_SIZE = AMOTION_EVENT_AXIS_SIZE;
    public static int AINPUT_MOTION_RANGE_TOUCH_MAJOR = AMOTION_EVENT_AXIS_TOUCH_MAJOR;
    public static int AINPUT_MOTION_RANGE_TOUCH_MINOR = AMOTION_EVENT_AXIS_TOUCH_MINOR;
    public static int AINPUT_MOTION_RANGE_TOOL_MAJOR = AMOTION_EVENT_AXIS_TOOL_MAJOR;
    public static int AINPUT_MOTION_RANGE_TOOL_MINOR = AMOTION_EVENT_AXIS_TOOL_MINOR;
    public static int AINPUT_MOTION_RANGE_ORIENTATION = AMOTION_EVENT_AXIS_ORIENTATION;
}

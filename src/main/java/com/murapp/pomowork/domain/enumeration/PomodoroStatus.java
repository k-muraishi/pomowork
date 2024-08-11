package com.murapp.pomowork.domain.enumeration;

public enum PomodoroStatus {
    Stop(0),
    Active(1);

    private int id;

    private PomodoroStatus(int id){
        this.id = id;
    }
}

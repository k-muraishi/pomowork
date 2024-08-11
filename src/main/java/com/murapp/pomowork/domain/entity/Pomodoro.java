package com.murapp.pomowork.domain.entity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import com.murapp.pomowork.domain.enumeration.PomodoroStatus;

import javax.swing.*;

public class Pomodoro extends JFrame {
    private String pomodoroId;
    private String userId;
    private long startMinutes;
    private long breakMinutes;
    private PomodoroStatus status;
    private Timer timer;

    public Pomodoro(String userId){
        this.pomodoroId = UUID.randomUUID().toString();
        this.userId = userId;
        this.startMinutes = 25 * 60;
        this.breakMinutes = 5;
        this.status = PomodoroStatus.Stop;
    }

    // timerクラスの初期化
    public void createTimer(JLabel timeLabel){
        this.timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (startMinutes > 0) {
                    startMinutes--;
                    timeLabel.setText(formatTime(startMinutes));
                } else {
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "Time's up!");
                }
            }
        });
    }

    public ActionListener start(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        };
    }

    public ActionListener stop(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        };
    }

    public ActionListener reset(JLabel timeLabel, String startMinutes){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                timeLabel.setText(startMinutes);
            }
        };
    }

    private String formatTime(long seconds) {
        long minutes = TimeUnit.SECONDS.toMinutes(seconds);
        long remainingSeconds = seconds - TimeUnit.MINUTES.toSeconds(minutes);
        return String.format("%02d:%02d", minutes, remainingSeconds);
    }

    public String getPomodoroId() {
        return pomodoroId;
    }

    public String getUserId() {
        return userId;
    }

    public String getStartMinutes() {
        return formatTime(startMinutes);
    }

    public long getBreakMinutes() {
        return breakMinutes;
    }

    public PomodoroStatus getStatus() {
        return status;
    }

    public Timer getTimer() {
        return timer;
    }
}

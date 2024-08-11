package com.murapp.pomowork.domain.entity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import com.murapp.pomowork.domain.enumeration.PomodoroStatus;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.swing.*;

public class Pomodoro {
    private String pomodoroId;
    private String userId;
    private Timeline timeline;
    private long startMinutes;
    private long breakMinutes;
    private PomodoroStatus status;
    private Timer timer;

    public Pomodoro(User user, JLabel timeLabel){
        this.pomodoroId = UUID.randomUUID().toString();
        this.userId = user.getUserId();
        this.startMinutes = 25 * 60;
        this.breakMinutes = 5;
        this.status = PomodoroStatus.Stop;
        this.timer = createTimer(timeLabel);
    }


    public Timer createTimer(JLabel timeLabel){
        return  new Timer(1000, new ActionListener() {
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

    public ActionListener Start(){
        if(this.status == PomodoroStatus.Active){
            throw new RuntimeException();
        }

        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        };
    }

    public ActionListener stop(){
        if(this.status == PomodoroStatus.Stop){
            throw new RuntimeException();
        }

        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        };
    }

    public ActionListener reset(JLabel timeLabel){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                timeLabel.setText(formatTime(startMinutes));
            }
        };
    }

    private String formatTime(long seconds) {
        long minutes = TimeUnit.SECONDS.toMinutes(seconds);
        long remainingSeconds = seconds - TimeUnit.MINUTES.toSeconds(minutes);
        return String.format("%02d:%02d", minutes, remainingSeconds);
    }
}

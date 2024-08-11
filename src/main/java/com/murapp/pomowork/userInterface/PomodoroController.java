package com.murapp.pomowork.userInterface;

import com.murapp.pomowork.domain.entity.Pomodoro;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

@RestController
@RequestMapping("pomopdoro")
public class PomodoroController {

     @GetMapping("/test")
     public  void test(){
         System.out.println("test");
     }

    @GetMapping("/init")
    public String pomodoroInit(@RequestParam("userId") String userId) {
        Pomodoro pomodoro = new Pomodoro(userId);

        JLabel timeLabel = new JLabel(pomodoro.getStartMinutes(), SwingConstants.CENTER);
        pomodoro.createTimer(timeLabel);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(pomodoro.start());
        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(pomodoro.stop());
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(pomodoro.reset(timeLabel));

        // Arrange components in the window
        pomodoro.setLayout(new BorderLayout());
        pomodoro.add(timeLabel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(resetButton);
        pomodoro.add(buttonPanel, BorderLayout.SOUTH);

        // Set up the window
        pomodoro.setTitle("Stopwatch App");
        pomodoro.setSize(300, 200);
        pomodoro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pomodoro.setLocationRelativeTo(null);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                pomodoro.setVisible(true);
            }
        });

        return pomodoro.getPomodoroId();
    }
}

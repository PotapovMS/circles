package ru.geekbrains.circles;

import java.awt.*;

public class Background extends Sprite {

  //переменная для задания значения красного спектра
  private static int red;
  private double time = 0d;

  public Background() {
    //инициализируем цвет начальными значениями
    //устанавливаем размер, как у канвы
    halfHeight = 300;
    halfWidth = 400;
  }

  @Override
  void update(GameCanvas gameCanvas, float deltaTime) {
      //используя дельту и функцию синуса задаем новый цвет через дельту времени
      red = Math.round((((float)(Math.sin(time))) * 128f) + 128f);

    //ограничиваем максимальным значением, допустимым для конструктора Color
    if (red > 255) {
      red = 255;
    }
        //увеличиваем время в каждой итерации на величину deltaTime
        time += deltaTime;
      }


  @Override
  void render(GameCanvas gameCanvas, Graphics g) {

    //устанавливаем новый цвет для объекта в зависимости от результата функции Math.sin()
    g.setColor(new Color(red, 128, 128));
    //заполняем этим цветом прямоугольник размером, равным канве
    g.fillRect(gameCanvas.getLeft(), gameCanvas.getTop(), gameCanvas.getWidth(), gameCanvas.getHeight());
  }
}

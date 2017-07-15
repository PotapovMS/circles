package ru.geekbrains.circles;

public class SpritesCollection {

  //счетчик для массива, чтобы определить, когда массив нужно увеличить
  private static int counter = 0;
  public Sprite[] sprites;


  //конструктор массива с заданной начальной емкостью
  public SpritesCollection(int capacity) {
    sprites = new Sprite[capacity];
  }

  public void add (Sprite sprite) {
    //если массив заполнен, создаем новый большей емкости и копируем в него старый
    if (counter == sprites.length) {
      Sprite[] tempSprites = new Sprite[counter*2];
      for (int i = 0; i < counter; i++) {
        tempSprites [i] = sprites[i];
      }
      sprites = tempSprites;
      tempSprites = null;
    }
    sprites[counter] = sprite;
    //после добавления элемента увеличиваем счетчик
    counter ++;
  }

  // получаем длину массива (он же счетчик)
  public int getLength() {
    return counter;
  }

  //возвращаем конкретный элемент по индексу
  public Sprite getElement (int index) {
    return sprites[index];
  }

}

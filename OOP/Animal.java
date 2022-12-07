package OOP;

class Animal {
  private String species;
  private int weight;

  public Animal(String s, int w) {
    species = s;
    weight = w;
  }

  public void setWeight(int x) {
    weight = x;
  }

  public int getWeight() {
    return weight;
  }
  
}

class Elephant extends Animal {
  private double trunkLength;

  public Elephant(int l) {
    super("Indian", 200);
    trunkLength = l;
  }

  public void eatMeal() {
     super.setWeight(super.getWeight() + 20);
  }

  public void walkAround() {
    super.setWeight(super.getWeight() - 5);
  }

  public void grow() {
    trunkLength += super.getWeight() % 4;
  }

  public String toString() {
    return "weight = " + super.getWeight() + " trunkLength = " + trunkLength;
  }

}

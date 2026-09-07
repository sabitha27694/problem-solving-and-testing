class FoodFactory extends Food {
    public Food getFood(String order) {
        if (order == null) {
            return null;
        }
        if (order.equalsIgnoreCase("pizza")) {
            return new Pizza();
        } else if (order.equalsIgnoreCase("cake")) {
            return new Cake();
        }
        return null;
    }
}
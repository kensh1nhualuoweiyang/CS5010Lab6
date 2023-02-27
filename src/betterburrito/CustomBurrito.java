package betterburrito;

import burrito.PortionSize;
import burrito.Protein;
import burrito.Size;
import burrito.Topping;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a custom burrito that can have an arbitrary number
 * of proteins and toppings, both of arbitrary portion sizes.
 */
public class CustomBurrito implements ObservableBurrito  {
    public static class CustomBurritoBuilder extends BurritoBuilder{
        protected final Map<Protein,PortionSize> proteinMap;

        public CustomBurritoBuilder(){
            super();
            proteinMap = new HashMap<>();
        }
        public CustomBurritoBuilder addProtein(Protein protein, PortionSize size){
            proteinMap.put(protein,size);
            return this;
        }

        public CustomBurrito build(){

        }
    }
    protected Size size;
    protected final Map<Protein, PortionSize> proteins;
    protected final Map<Topping,PortionSize> toppings;

    /**
     * Create a custom burrito of the specified size.
     * @param size the size of this burrito
     */
    public CustomBurrito(Size size) {
        this.size = size;
        this.proteins = new HashMap<Protein,PortionSize>();
        this.toppings = new HashMap<Topping,PortionSize>();

    }

    @Override
    public PortionSize hasTopping(Topping name) {
        return this.toppings.getOrDefault(name,null);
    }

    @Override
    public PortionSize hasProtein(Protein name) {
        return this.proteins.getOrDefault(name,null);
    }

    @Override
    public double cost() {
        double cost = 0.0;
        for (Map.Entry<Protein, PortionSize> item : this.proteins.entrySet()) {
            cost += item.getKey().getCost() * item.getValue().getCostMultipler();
        }

        for (Map.Entry<Topping, PortionSize> item : this.toppings.entrySet()) {
            cost += item.getKey().getCost() * item.getValue().getCostMultipler();
        }
        return cost + this.size.getBaseCost();
    }


}

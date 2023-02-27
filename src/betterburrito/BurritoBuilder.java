package betterburrito;

import burrito.PortionSize;
import burrito.Protein;
import burrito.Size;
import burrito.Topping;

import java.util.HashMap;
import java.util.Map;

public abstract class BurritoBuilder {
    protected Size size;
    protected final Map<Topping, PortionSize> toppingMap;
    public BurritoBuilder(){
        toppingMap = new HashMap<>();
    }

    public BurritoBuilder size(Size size){
        this.size = size;
        return this;
    }

    public BurritoBuilder addTopping(Topping topping, PortionSize size){
        toppingMap.put(topping,size);
        return this;
    }
}

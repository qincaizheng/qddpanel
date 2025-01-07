package com.example.mysupermod;

import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIAPI;

public class JEIDataFetcher {
    public static void fetchJEIData() {
        IModRegistry jeiRegistry = JEIAPI.getJeiHelpers().getIngredientBlacklist();
        // 这里你可以获取和显示 JEI 数据
    }
}

package iy.jspspring.training.controller

class TestGroovy {
    String name
    String password



    Collection reverseCollection(def collection){
        collection?.reverse()
    }
}

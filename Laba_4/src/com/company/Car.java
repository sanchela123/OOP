package com.company;

public	class	Car	implements	Printable{
    String	brand;
    String	model;
    int	price;
    int	year;
    public	String	getBrand()	{
        return	brand;
    }
    public	String	getModel()	{
        return	model;
    }
    public	int	getPrice()	{
        return	price;
    }
    public	int	getYear()	{
        return	year;
    }
    Car	(String	brand,	String	model,	int	price, int	year)
    {
        this.brand	=	brand;
        this.model	=	model;
        this.price	=	price;
        this.year	=	year;
    }
    public	void	println(){
        System.out.println("Автомобиль:	"	+ brand + "	Модель:	"	+ model + "	Цена "	+ price +	"	Год	выпуска:"	+ year);
    }
}
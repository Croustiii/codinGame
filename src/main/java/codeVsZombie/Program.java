package codeVsZombie;

import java.util.Dictionary;

public class Program {


    static void Main(string[] args)
    {

        // Code VS Zombies
        //Mapper map = new Mapper();
        //Zombie zomb = new Zombie(6, 2, 5, 2);

        //map.AddZombie(zomb);
        //zomb.CalcDistance();
        //Console.WriteLine(zomb.TargetDistance);

        // Human position
        Point p = new Point(8250, 4500);

        Zombie Z0 = new Zombie(8250, 5399, 8250, 4999);
        Mapper map = new Mapper();
        Console.WriteLine(Z0.CalcDistance());

        //var test = new Dictionary<int, Zombie>();

        //test.Add(1, new Zombie(1, 2, 3, 4));



        Console.ReadKey();
        Console.ReadLine();

    }
}

public class Mapper
{
    public Dictionary<Integer,Zombie> Zombies;

    public Dictionary<Integer, Point> Humans;

    public Mapper()
    {
        Zombies = new Dictionary<Integer, Zombie>();
        Humans = new Dictionary<Integer, Point>();
    }

    public void AddZombie(int id,Zombie zomb)
    {
        Zombies.Add(id,zomb);

    }
    public void AddHuman (int id, Point p)
    {
        Humans.Add(id, p);
    }
}
    class Zombie
    {
        /// <summary>
        /// position of the zombie
        /// </summary>
        public Point Position;

        /// <summary>
        /// position of target
        /// </summary>
        public Point Target;

        /// <summary>
        /// Distance to Target
        /// </summary>
        public double TargetDistance;

        public Zombie(double x, double y, double Tx, double Ty)
        {
            Position = new Point(x, y);

            Target = new Point(Tx,Ty);
        }

        public double CalcDistance ()
        {
            var termA = Target.X - Position.X;
            var termB = Target.Y - Position.Y;

            TargetDistance = Math.sqrt(Math.pow(termA, 2) + Math.pow(termB, 2));

            return TargetDistance;
        }
    }
    class Point
    {
        public double X;
        public double Y;
        public Point (double x, double y)
        {
            X = x;
            Y = y;
        }
    }
}

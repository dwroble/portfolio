using EFCore_Demo.Models;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;

namespace EFCore_Demo.DBContext
{
    public class AppDbContext : DbContext
    {
        public DbSet<Blog> Blog { get; set; }
        public DbSet<Comment> Comments { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            /**
             * This is where the optionsBuilder will have to be set to the unique instance of the database server and connection being used
             * See more at https://learn.microsoft.com/en-us/dotnet/api/microsoft.entityframeworkcore.dbcontextoptionsbuilder?view=efcore-8.0
             * 
             */

        }
    }

}

using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EFCore_Demo.Models
{
    public class Blog
    {

        public Blog()
        {
            CommentsList = [];
        }
        public int? Id { get; set; } = default;
        public string? Title { get; set; } = "";
        public string? Content { get; set; } = "";
        public DateTime DateCreated { get; set; } = DateTime.Now;
        public IEnumerable<Comment> CommentsList;
    }
}

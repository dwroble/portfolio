using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EFCore_Demo.Models
{
    public class Comment
    {
        public int? Id { get; set; } = default;
        public string? Content { get; set; } = "";
        public DateTime? DateCreated { get; set; } = DateTime.Now;
        public int? BlogID { get; set; } = default;

    }
}

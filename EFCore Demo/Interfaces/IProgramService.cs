using EFCore_Demo.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EFCore_Demo.Interfaces
{
    public interface IProgramService
    {
        Blog GetBlogByID(int id);
        Blog CreateBlog(Blog blog);
        IEnumerable<Blog> GetBlogList();
        Comment CreateCommentOnBlog(Comment comment);
        IEnumerable<Comment> GetAllCommentsInBlogByBlogID(int blogID);
    }
}

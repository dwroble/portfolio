using EFCore_Demo.DBContext;
using EFCore_Demo.Interfaces;
using EFCore_Demo.Models;

namespace EFCore_Demo.Services
{
    public class AppService : IAppService
    {
        public Blog CreateBlog(Blog blog)
        {
            using (var context = new AppDbContext())
            {
                context.Blog.Add(blog);
                context.SaveChanges();
            }

            return blog;
        }

        public IEnumerable<Blog> GetBlogList()
        {
            IEnumerable<Blog> list = [];
            using (var context = new AppDbContext())
            {
                list = [.. context.Blog];
            }

            return list;
        }

        public Blog? GetBlogByID(int id)
        {
            Blog? blog = new();
            using (var context = new AppDbContext())
            {
                blog = context.Blog.Find(id);
            }
            return blog;
        }

        public Comment CreateCommentOnBlog(Comment comment)
        {
            using(var context = new AppDbContext())
            {
                context.Comments.Add(comment);
                context.SaveChanges();
            }

            return comment;
        }

        public IEnumerable<Comment> GetAllCommentsInBlogByBlogID(int blogID)
        {
            IEnumerable<Comment> commentsList = [];
            using (var context = new AppDbContext())
            {
                commentsList = [.. context.Comments];
            }

            return commentsList.Where(x => x.BlogID == blogID);
        }
    }
}

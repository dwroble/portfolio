using EFCore_Demo.Interfaces;
using EFCore_Demo.Models;
using EFCore_Demo.Services;
using Microsoft.Extensions.DependencyInjection;

namespace EFCore_Demo
{
    class Program
    {
        static void Main(string[] args)
        {
            var serviceProvider = new ServiceCollection()
                .AddTransient<IAppService, AppService>()
                .AddTransient<IProgramService, ProgramService>()
                .BuildServiceProvider();

            var appService = serviceProvider.GetService<IAppService>()!;
            var programService = serviceProvider.GetService<IProgramService>()!;

            Init(programService);
        }

        static void Init(IProgramService programService)
        {
            try
            {
                int initSelection = -1;
                do
                {
                    Console.WriteLine("1: Make a Selection:\n" +
                        "1. Create a new blog\n" +
                        "2. View a blog\n" +
                        "3. Delete a blog\n" +
                        "9. Exit Program");

                    var inputSelection1 = Console.ReadLine();
                    if (Int32.TryParse(inputSelection1, out initSelection))
                    {
                        switch (initSelection)
                        {
                            case 1: // Create a blog
                                try
                                {
                                    Console.WriteLine("Enter the title for this blog");
                                    string title = !Console.ReadLine()!.Equals("") ? Console.ReadLine()! : "Null Title";
                                    Console.WriteLine("Begin writing your blog content. Press Enter to submit.");
                                    string content = !Console.ReadLine()!.Equals("") ? Console.ReadLine()! : "Null Content.";
                                    Blog blogTemplate = new()
                                    {
                                        Title = title,
                                        Content = content
                                    };
                                    programService.CreateBlog(blogTemplate);
                                }
                                catch (Exception e)
                                {

                                }
                                break;
                            case 2: // View a blog
                                try
                                {
                                    do
                                    {
                                        Console.Clear();

                                        List<Blog> blogList = programService.GetBlogList().ToList<Blog>();
                                        int numberOfBlogs = blogList.Count;

                                        for (int i = 0; i < numberOfBlogs; i++)
                                        {
                                            Console.WriteLine($"ID #: {blogList[i].Id} \tTitle: {blogList[i].Title}");
                                        }

                                        Console.WriteLine("Please make a selection or enter 0 to go back to the previous menu.");

                                        var inputSelection2 = Console.ReadLine();
                                        int blogSelection = -1;

                                        if (int.TryParse(inputSelection2, out blogSelection))
                                        {
                                            if (blogSelection == 0)
                                            {
                                                break;
                                            }

                                            Blog blog = blogList[blogSelection - 1];
                                            List<Comment> commentsList = programService.GetAllCommentsInBlogByBlogID(blogSelection).ToList<Comment>();

                                            Console.WriteLine("======================================================\n" +
                                                $"Title: " +
                                                $"\t{blog.Title}\n\n" +
                                                $"{blog.Content}\n\n" +
                                                $"Date Posted:" +
                                                $"\n{blog.DateCreated}\n\n" +
                                                $"Comments:");

                                            for (int i = 0; i < commentsList.Count; i++)
                                            {
                                                Console.WriteLine($"\nID #: {commentsList[i].Id}" +
                                                    $"\nMessage:" +
                                                    $"\n{commentsList[i].Content}\n\n" +
                                                    $"Date Posted:\n" +
                                                    $"{commentsList[i].DateCreated}\n" +
                                                    $"======================================================");
                                            }

                                            Console.WriteLine("======================================================\n" +
                                                "Would you like to leave a comment on this blog? Y/N.");
                                            if (Console.ReadLine()!.ToLower() == "y")
                                            {
                                                Console.WriteLine("Begin writing your comment. Press Enter to submit.");
                                                string commentString = Console.ReadLine();
                                                if (commentString.Equals("")) commentString = "Null Content!";
                                                Comment comment = programService.CreateCommentOnBlog(new Comment() { Content = commentString, BlogID = blogSelection });
                                                Console.WriteLine("Comment has been created");
                                                break;
                                            }
                                        }
                                        else
                                        {
                                            // Error in user input
                                            Console.WriteLine("Error in user input. Try again");
                                        }
                                    } while (true);
                                }
                                catch (Exception e)
                                {

                                }
                                break;
                            default:
                                if (initSelection != 9)
                                    Console.WriteLine("Error in user input. Try again");
                                break;
                        }
                    }
                    else
                    {
                        // Error in user input
                        Console.WriteLine("Error in user input. Try again");
                    }
                } while (initSelection != 9);
            }
            catch (Exception ex)
            {

            }

        }

    }
}
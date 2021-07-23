using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Server
{
    class Fatura
    {

        public string name { get; set; }
        public string email { get; set; }
        public string password { get; set; }
        public string confirmpassword { get; set; }
        public string fatura { get; set; }
        public string viti { get; set; }
        public string vlera { get; set; }

        public Fatura(string name, string email, string password, string confirmpassword, string fatura, string viti, int vlera)
        {
            this.name = name;
            this.email = email;
            this.password = password;
            this.confirmpassword = confirmpassword;
            this.fatura = fatura;
            this.viti = viti;
            this.vlera = vlera;
        }

        public Fatura()
        {

        }

    }
}

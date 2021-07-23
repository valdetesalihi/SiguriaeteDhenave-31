using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Forms1
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void label5_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (txtName.Text == "your_name" && txtEmail.Text == "your_email" && txtPass.Text == "your_password" && txtConfirm.Text == "your_password" &&
                txtFatura.Text == "your_fatura" && txtViti.Text == "your_viti" && txtVlera.Text == "your_vlera")
            {
                this.Hide();

            }
            else
            {
                MessageBox.Show("Something went wrong, try again!");
                txtName.Clear();
                txtEmail.Clear();
                txtPass.Clear();
                txtConfirm.Clear();
                txtFatura.Clear();
                txtViti.Clear();
                txtVlera.Clear();
            }
        }
    }
}
